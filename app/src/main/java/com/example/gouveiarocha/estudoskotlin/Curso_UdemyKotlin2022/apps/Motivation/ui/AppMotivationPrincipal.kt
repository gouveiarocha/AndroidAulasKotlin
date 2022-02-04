package com.example.gouveiarocha.estudoskotlin.Curso_UdemyKotlin2022.apps.Motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gouveiarocha.estudoskotlin.R

class AppMotivationPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_act_motivation_principal)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

    }
}