package com.example.gouveiarocha.estudoskotlin.Curso_UdemyKotlin2022.estudos.Kotlin.Secao27_MaisSobreFuncoes2

import java.text.SimpleDateFormat
import java.util.*

/**
 * Funções internas
 * Funções declaradas dentro outras funções. Possivel apenas no escopo da função em que ela esta inserida.
 */

fun top(){

    //log() - erro, função interna precisa ser chamada após sua criação.

    fun log(str: String){
        val calendar = Calendar.getInstance()
        val formatted = SimpleDateFormat("HH:mm:ss")
        println("$str - ${formatted.format(calendar.time)}")
    }

    log("Início")
    //-------------
    log("Fim")

}

fun log(){

}

fun main() {

    //log() - não posso mais chamar a fun log
    //top().log() - também não posso

    top()

}