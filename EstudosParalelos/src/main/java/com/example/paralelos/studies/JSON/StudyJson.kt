package com.example.paralelos.studies.JSON

import com.google.gson.Gson

fun main() {
    
}

private fun study1(){

    // Para Json
    val filme1 = Filme("Eu Aqui", 2020)
    filme1.generos.add("Comédia")
    filme1.generos.add("Ação")
    val gson1 = Gson().toJson(filme1)
    println(gson1)

    // De Json
    val strJson = "{\"titulo\":\"JSON James\",\"ano\":2012,\"generos\":[\"Western\"]}"
    val filme2: Filme = Gson().fromJson(strJson, Filme::class.java)
    println(filme2.titulo)
    println(filme2.ano)
    println(filme2.generos)

}

private fun study2(){

}

class Filme(val titulo: String = "", val ano: Int = 0) {
    val generos = arrayListOf("")
}