package com.example.gouveiarocha.estudoskotlin.studies.Kotlin.Secao27_MaisSobreFuncoes2

/**
 * Especificação das funções highorder
 */

fun main() {

    //Funções
    fun sum(x: Int, y: Int) = x + y
    fun multiply(x: Int, y: Int) = x * y
    fun operator(x: Int, y: Int, op: (Int, Int) -> Int): Int {
        return op(x, y)
    }

    operator(1, 2, ::sum)
    operator(1, 2, ::multiply)

    //lambdas

    val l1 = { a: Int, b: Int -> a + b }
    val l2: (Int, Int) -> Int = { nubem1, number2 -> nubem1 + number2 }

    operator(10, 20, { a: Int, b: Int -> a + b }) //1º forma
    operator(10, 20, l1) //2º forma
    operator(10, 20, l2) //3º forma


}


