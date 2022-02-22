package com.example.estudos_kotlin.Livro_KotlinEmAcao

fun main() {

    println(max(12, 9))
    println(yearsToCompute)

}

//2.1.2 funções

//first function example
//fun block body -> corpo de bloco -> funções que possuem seu corpo entre chaves.
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b //expression with resulting value
}

//fun expression body -> corpo de expressão -> funções que devolvem uma expressão.
fun max2(a: Int, b: Int): Int = if (a > b) a else b

//simplificando ainda mais!
//função inferindo o tipo de retorno... O Kotlin sabe o tipo de retorno da função pela sua expressão.
fun max3(a: Int, b: Int) = if (a > b) a else b

//resumo Instruções e expressões
//Em Kotlin, if é uma expressão e não uma instrução, como em java. A diferença é que uma expressão tem um valor e pode
//ser usado como parte de outra expressão. No kotlin, a maioria das estruturas de controle são expressões, exceto os
//laçoes de repetição, como for, do e do while.

//2.1.3 variáveis

//Podemos ou não definir o tipo da varável. Caso omitimos, o Kt irá tentar inferir o tipo por nós.
val question = "The Ultimate Question of Lige, the Universe, and Everything" //inferencia para String
val answer = 42 //inferencia para Int.
val answer2: Int = 42 //declarando o tipo
val yearsToCompute = 7.5e6


