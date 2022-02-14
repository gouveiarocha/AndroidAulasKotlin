package com.example.gouveiarocha.estudoskotlin.AcitivitysPrincipais

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gouveiarocha.estudoskotlin.Curso_UdemyKotlin2022.apps.Motivation.ui.AppMotivationHome
import com.example.gouveiarocha.estudoskotlin.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this, AppMotivationHome::class.java))

    }

}