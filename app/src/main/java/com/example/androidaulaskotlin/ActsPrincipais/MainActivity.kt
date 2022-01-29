package com.example.androidaulaskotlin.ActsPrincipais

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidaulaskotlin.ActsEstudos.MVVM.MVVM
import com.example.androidaulaskotlin.ActsEstudos.M_ActForResult.FirstScreen
import com.example.androidaulaskotlin.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this, FirstScreen::class.java))

    }
}