package com.example.gouveiarocha.estudoskotlin.estudos.MVVM

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gouveiarocha.estudoskotlin.R
import kotlinx.android.synthetic.main.activity_mvvm.*

class MVVM : AppCompatActivity() {

    private lateinit var mViewModel: MVVMVielModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm)

        mViewModel = ViewModelProvider(this).get(MVVMVielModel::class.java)

        //Inicializa Observers
        this.createObservers()

        buttonLogin.setOnClickListener {
            val name = editName.text.toString()
            mViewModel.doLogin(name)

        }

    }

    fun createObservers() {

        //Observer textWelcome
        mViewModel.textWelcome.observe(this, Observer {
            textWelcome.text = it
        })

        //Observer login
        mViewModel.login.observe(this, {
            if (it) {
                Toast.makeText(applicationContext, "Sucesso!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Falha!", Toast.LENGTH_SHORT).show()
            }
        })

    }

}