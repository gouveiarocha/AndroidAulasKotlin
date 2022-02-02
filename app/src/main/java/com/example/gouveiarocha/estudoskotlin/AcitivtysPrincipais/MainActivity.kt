package com.example.gouveiarocha.estudoskotlin.AcitivtysPrincipais

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gouveiarocha.estudoskotlin.Curso_UdemyKotlin2022.estudos.Elementos_Secoes_20_24.EstudoElementos2
import com.example.gouveiarocha.estudoskotlin.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this, EstudoElementos2::class.java))

    }
}