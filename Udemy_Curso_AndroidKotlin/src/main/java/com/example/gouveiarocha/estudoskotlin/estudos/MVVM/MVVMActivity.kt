package com.example.gouveiarocha.estudoskotlin.estudos.MVVM

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gouveiarocha.estudoskotlin.databinding.ActivityMvvmBinding
import kotlinx.android.synthetic.main.activity_mvvm.*

class MVVMActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMvvmBinding.inflate(layoutInflater)
    }

    private lateinit var mViewModel: MVVMVielModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        mViewModel = ViewModelProvider(this).get(MVVMVielModel::class.java)

        //Inicializa Observers
        this.createObservers()

        //Evento de clique botão de Login
        binding.buttonLogin.setOnClickListener {
            val name = editName.text.toString()
            mViewModel.doLogin(name)
        }

    }

    fun createObservers() {

        //Observer textWelcome
        mViewModel.welcome().observe(this, Observer {
            textWelcome.text = it
        })

        //Observer login
        mViewModel.login().observe(this, Observer {
            if (it) {
                Toast.makeText(applicationContext, "Sucesso!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Falha!", Toast.LENGTH_SHORT).show()
            }
        })

    }

}