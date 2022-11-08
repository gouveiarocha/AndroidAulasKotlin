package com.gouveia.android_main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.gouveia.android_main.utils.extensions.preventScreenshotsAndRecentAppThumbnails

// SINGLE PAGE APPLICATION - NESSE PROJETO, VAMOS TENTAR USAR APENAS UMA ACITIVTY.
// VANTAGEM: VOCÊ FAZ A CONFIGURACÃO UMA ÚNICA VEZ EM UM LUGAR CENTRAL!

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // OFUSCAMENTO DE TELA
        // Colocando aqui no onCreate da activity, a ofuscação vai se extender para todas as telas
        // vinculadas a essa activity, inclusive os fragments.
        preventScreenshotsAndRecentAppThumbnails()

    }

}