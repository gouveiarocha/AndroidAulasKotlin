package com.example.gouveiarocha.estudoskotlin.Paralelos.Apps.Jokenpo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.gouveiarocha.estudoskotlin.R
import kotlinx.android.synthetic.main.activity_app_jokenpo.*
import kotlin.random.Random

/**
 * MVT. Refatorar para MVVM.
 */

class AppJokenpo : AppCompatActivity() {

    var escolhaUsuario: Int = 0
    var escolhaApp: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_jokenpo)

        img_pedra.setOnClickListener(View.OnClickListener {
            escolhaUsuario = 0
            escolhaApp = Random.nextInt(3)
            verificarVencedor()
        })

        img_papel.setOnClickListener(View.OnClickListener {
            escolhaUsuario = 1
            escolhaApp = Random.nextInt(3)
            verificarVencedor()
        })

        img_tesoura.setOnClickListener(View.OnClickListener {
            escolhaUsuario = 2
            escolhaApp = Random.nextInt(3)
            verificarVencedor()
        })

    }

    fun verificarVencedor() {

        configurarOpcoes()

        if (
            escolhaUsuario == 1 && escolhaApp == 0 ||
            escolhaUsuario == 0 && escolhaApp == 2 ||
            escolhaUsuario == 2 && escolhaApp == 1
        ) {
            res.setText("USUARIO GANHOU!!!")

        } else if (
            escolhaUsuario == 2 && escolhaApp == 0 ||
            escolhaUsuario == 1 && escolhaApp == 2 ||
            escolhaUsuario == 0 && escolhaApp == 1
        ) {
            res.setText("APP GANHOU!!!")

        } else {
            res.setText("EMPATE")
        }

    }

    fun configurarOpcoes(){

        when (escolhaUsuario){

            0 -> opcaoUsuario.setImageResource(R.drawable.img_jokenpo_pedra)
            1 -> opcaoUsuario.setImageResource(R.drawable.img_jokenpo_papel)
            2 -> opcaoUsuario.setImageResource(R.drawable.img_jokenpo_tesoura)

        }

        when (escolhaApp){

            0 -> opcaoApp.setImageResource(R.drawable.img_jokenpo_pedra)
            1 -> opcaoApp.setImageResource(R.drawable.img_jokenpo_papel)
            2 -> opcaoApp.setImageResource(R.drawable.img_jokenpo_tesoura)

        }

    }

}