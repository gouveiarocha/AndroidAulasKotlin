package com.example.appaulaskotlin.ActsPrincipais

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appaulaskotlin.ActsApps.AppJokenpo
import com.example.appaulaskotlin.ActsAulas.APIRetrofit.APIRetrofit
import com.example.appaulaskotlin.ActsAulas.MVVM.MVVM
import com.example.appaulaskotlin.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this, MVVM::class.java))

    }
}