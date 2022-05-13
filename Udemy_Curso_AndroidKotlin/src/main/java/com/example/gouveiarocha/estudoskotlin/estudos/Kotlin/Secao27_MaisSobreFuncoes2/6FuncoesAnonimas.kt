package com.example.gouveiarocha.estudoskotlin.estudos.Kotlin.Secao27_MaisSobreFuncoes2

fun main() {

    //Funções
    fun operator(x: Int, y: Int, op: (Int, Int) -> Int): Int {
        return op(x, y)
    }

    //Função anônima declarada nos parametros.
    operator(1, 2, fun(n1: Int, n2: Int): Int {
        return n1 + n2
    })

}