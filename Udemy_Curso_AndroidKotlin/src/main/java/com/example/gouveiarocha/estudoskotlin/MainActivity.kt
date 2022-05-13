package com.example.gouveiarocha.estudoskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gouveiarocha.estudoskotlin.apps.GastoViagem.AppGastoViagem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this, AppGastoViagem::class.java))

    }

}