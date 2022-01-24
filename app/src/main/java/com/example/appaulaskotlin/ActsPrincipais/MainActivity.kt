package com.example.appaulaskotlin.ActsPrincipais

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appaulaskotlin.ActsEstudos.MVVM.MVVM
import com.example.appaulaskotlin.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this, MVVM::class.java))
        //novo teste

    }
}