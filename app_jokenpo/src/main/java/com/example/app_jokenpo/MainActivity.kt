package com.example.app_jokenpo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

/**
 * MVTudo kkk -> Refatorar para MVVM e demais boas práticas.
 */

class MainActivity : AppCompatActivity() {

    var escolhaUsuario: Int = 0
    var escolhaApp: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



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

            0 -> opcaoUsuario.setImageResource(R.drawable.jokenpo_img_stone)
            1 -> opcaoUsuario.setImageResource(R.drawable.jokenpo_img_paper)
            2 -> opcaoUsuario.setImageResource(R.drawable.jokenpo_img_scissors)

        }

        when (escolhaApp){

            0 -> opcaoApp.setImageResource(R.drawable.jokenpo_img_stone)
            1 -> opcaoApp.setImageResource(R.drawable.jokenpo_img_paper)
            2 -> opcaoApp.setImageResource(R.drawable.jokenpo_img_scissors)

        }

    }

}