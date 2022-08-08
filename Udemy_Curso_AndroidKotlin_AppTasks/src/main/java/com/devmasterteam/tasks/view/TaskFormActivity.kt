package com.devmasterteam.tasks.view

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.devmasterteam.tasks.R
import com.devmasterteam.tasks.databinding.ActivityTaskFormBinding
import com.devmasterteam.tasks.service.constants.TaskConstants
import com.devmasterteam.tasks.service.model.PriorityModel
import com.devmasterteam.tasks.service.model.TaskModel
import com.devmasterteam.tasks.viewmodel.TaskFormViewModel
import java.text.SimpleDateFormat
import java.util.*

class TaskFormActivity : AppCompatActivity(), View.OnClickListener,
    DatePickerDialog.OnDateSetListener {

    private lateinit var viewModel: TaskFormViewModel
    private lateinit var binding: ActivityTaskFormBinding

    private val dateFormat = SimpleDateFormat("dd/MM/yyyy")
    private var listPriority: List<PriorityModel> = mutableListOf()
    private var taskIdentification = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Instancia e Inicializa o Layout com o binding.
        binding = ActivityTaskFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Instancia e Inicializa a ViewModel.
        viewModel = ViewModelProvider(this).get(TaskFormViewModel::class.java)

        // Init Click Listener(s).
        binding.buttonSave.setOnClickListener(this)
        binding.buttonDate.setOnClickListener(this)

        // Load Bundle Data
        loadDataFromActivity()

        // Init Observer(s).
        observe()

        viewModel.loadPriorities()

    }

    private fun loadDataFromActivity() {
        val bundle = intent.extras
        if (bundle != null) {
            binding.buttonSave.text = "Salvar Tarefa"
            taskIdentification = bundle.getInt(TaskConstants.BUNDLE.TASKID)
            viewModel.loadTask(taskIdentification)
        }
    }

    private fun observe() {

        viewModel.priorityList.observe(this) {
            listPriority = it
            val list = mutableListOf<String>()
            for (p in it) {
                list.add(p.description)
            }
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, list)
            binding.spinnerPriority.adapter = adapter
        }

        viewModel.taskSave.observe(this) {
            if (it.status()) {
                if (taskIdentification == 0){
                    showToast("Sucesso ao Cadastrar nova Tarefa!")
                }else{
                    showToast("Sucesso ao Atualizar Tarefa!")
                }
                finish()
            } else {
                showToast(it.message())
            }
        }

        viewModel.task.observe(this) {
            binding.editDescription.setText(it.description)
            binding.spinnerPriority.setSelection(getIndex(it.priorityId))
            binding.checkComplete.isChecked = it.complete

            val date = SimpleDateFormat("yyyy-MM-dd").parse(it.dueDate)
            val dateFormated = SimpleDateFormat("dd/MM/yyyy").format(date)
            binding.buttonDate.text = dateFormated

        }

    }

    private fun handleDate() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this, this, year, month, dayOfMonth).show()
    }

    private fun handleSave() {
        val task = TaskModel().apply {
            this.id = taskIdentification
            this.description = binding.editDescription.text.toString()

            // Tratamento para pegar o item selecionado do Spinner. Importante usar index.
            // Pois, nesse caso, o index vai ser diferente do nosso id.
            val index = binding.spinnerPriority.selectedItemPosition
            this.priorityId = listPriority[index].id

            this.complete = binding.checkComplete.isChecked
            this.dueDate = binding.buttonDate.text.toString()

        }
        viewModel.save(task)
    }

    private fun getIndex(id: Int): Int {
        var index = 0
        for (l in listPriority) {
            if (l.id == id) {
                break
            }
            index++
        }
        return index
    }

    private fun showToast(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_date -> handleDate()
            R.id.button_save -> handleSave()
            else -> return
        }
    }

    override fun onDateSet(dp: DatePicker, year: Int, month: Int, dayOfMonth: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)
        val dueDate = dateFormat.format(calendar.time)
        binding.buttonDate.text = dueDate
    }

}