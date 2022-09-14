package com.example.gouveiarocha.estudoskotlin.estudos.Elementos_Secoes_19_38

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.size
import com.example.gouveiarocha.estudoskotlin.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_study_elements2.*

class StudyElementsActivity2 : AppCompatActivity(), View.OnClickListener,
    AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study_elements2)

        initElements()
        loadDynamicSpinner()

    }

    override fun onClick(v: View) {
        when (v.id) {

            R.id.btn_toast_test -> {
                showToast("Teste Toast")
            }
            R.id.btn_toast_test_cust -> {
                val toast = Toast.makeText(this, "Teste!!!", Toast.LENGTH_LONG)

                // Pegando o elemento da Toast para modifica-lo.
                //val textView = toast.view?.findViewById<TextView>(android.R.id.message)
                //textView?.setTextColor(Color.RED)

                // Muda a posição da Toast
                toast.setGravity(Gravity.CENTER, 0, 0)

                // Definindo um layout customizado para a Toast
                val layout = layoutInflater.inflate(R.layout.toast_layout, null)
                toast.view = layout

                toast.show()
            }
            R.id.btn_snack_test -> {
                snack("Teste Snack!!!")
            }
            R.id.btn_spinner_get_test -> {
                val selectedItem = spinner_static_test.selectedItem
                val selectedItemId = spinner_static_test.selectedItemId
                val selectedItemPosition = spinner_static_test.selectedItemPosition
                showToast("[Botões Testes] = Position: $selectedItemPosition - ID: $selectedItemId - Texto: $selectedItem")
            }
            R.id.btn_spinner_set_test -> {
                // Só aceita o set pelo ID
                spinner_static_test.setSelection(3)
            }

        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (parent?.id) {
            R.id.spinner_static_test -> {
                val selectedItem = parent.selectedItem
                val selectedItemId = parent.selectedItemId
                val selectedItemPosition = parent.selectedItemPosition
                showToast("[OnItemSelect] = Position: $selectedItemPosition - ID: $selectedItemId - Texto: $selectedItem")
            }
            R.id.spinner_dynamic_test -> {
                //Ações de seleção no Spinner Dinamico.
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        showToast("nothing")
    }

    /**
     * ---> Métodos
     */

    private fun showToast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }

    private fun snack(str: String) {
        // Cria a Snack, observar que obrigatoriamente precisa de um Layout pai. No Caso o linear_root.
        val snack = Snackbar.make(linear_root, str, Snackbar.LENGTH_LONG)
        // Cria ação no Snack.
        snack.setAction("Desfazer", View.OnClickListener {
            showToast("Desfeito...")
        })
        // Customiza cores.
        snack.setActionTextColor(Color.BLUE)
        snack.setBackgroundTint(Color.LTGRAY)

        snack.show()
    }

    private fun initElements() {

        btn_toast_test.setOnClickListener(this)
        btn_toast_test_cust.setOnClickListener(this)
        btn_snack_test.setOnClickListener(this)
        btn_spinner_get_test.setOnClickListener(this)
        btn_spinner_set_test.setOnClickListener(this)

        spinner_static_test.onItemSelectedListener = this

    }

    private fun loadDynamicSpinner() {
        val mList = listOf("Gramas Spinner Dinamico", "Kg Spinner Dinamico", "Arroba Spinner Dinamico", "Tonelada Spinner Dinamico")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, mList)
        spinner_dynamic_test.adapter = adapter
    }

}