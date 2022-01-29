package com.example.androidaulaskotlin.UdemyKotlin.estudos.Kotlin.Secao27_MaisSobreFuncoes2

/**
 * HighOrderFuncitons - ou Função de ordem maior.
 * Função como parametro de outra função, exemplos abaixo
 */

fun main() {

    val intList = listOf(1, 2, 3, 4)
    val strList = listOf("A", "B", "C", "D")
    val map = mapOf(Pair("FR", "França"), Pair("BR", "Brasil"))

    //1º exemplo, passamos a fun println como parametro
    intList.forEach { print(it) }
    intList.paraCada { print(it) }
    strList.paraCada { print(it) } //permitido apos tranformar a fun paraCada com tipo generico
    map.values.paraCada { print(it) } //permitido apos mudar para um tipo mais generico na fun paraCada - de List para Iterable

    println(operator(5, 5, ::sum))
    println(operator(5, 5, ::multiply))

}

fun operator(x: Int, y: Int, op: (Int, Int) -> Int): Int {
    return op(x, y)
}

fun sum(x: Int, y: Int) = x + y
fun multiply(x: Int, y: Int) = x * y

//fun paraCada convertida de int para genérica.
fun <T> Iterable<T>.paraCada(op: (T) -> Unit) {
    for (i in this) {
        op(i)
    }
    println("")
    //mais codigos
}


