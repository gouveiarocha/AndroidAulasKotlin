package com.example.gouveiarocha.estudoskotlin.AcitivtysPrincipais

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gouveiarocha.estudoskotlin.Paralelos.Estudos.LoginMVP.activitys.LoginMVP_LoginActivity
import com.example.gouveiarocha.estudoskotlin.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this, LoginMVP_LoginActivity::class.java))

    }
}