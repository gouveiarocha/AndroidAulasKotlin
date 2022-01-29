package com.example.androidaulaskotlin.UdemyKotlin.estudos.Kotlin.MyCodes.KOAN

const val question = "life, the universe, and everything"
const val answer = 42

val tripleQuotedString = """
    #question = "$question"
    #answer = $answer""".trimMargin("#")

fun main() {
    println(tripleQuotedString)
}