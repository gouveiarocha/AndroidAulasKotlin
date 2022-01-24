package Secao7_ControleFluxo

/**
 * Diferente de grande parte das linguagens atuais, if else é uma expressão em Kotlin
 * Sendo uma expressão, ela é capaz de retornar valor.
 */

fun main() {

    println(maiorDeIdade2(15))
    println(maiorDeIdade3(26))
    println(saudacao(false))

}

//Normal
fun maiorDeIdade2(idade: Int) {
    if (idade >= 18) {
        println("Maior de idade.")
    } else {
        println("Menor de idade.")
    }
}

//Retornando valor ex1
fun maiorDeIdade3(idade: Int): String {
    return if (idade >= 18) {
        "Maior de idade."
    } else {
        "Menor de idade."
    }
}

//Retornando valor ex2
fun saudacao(dia: Boolean): String {
    return if (dia) {
        "Bom dia"
    } else {
        "Boa noite"
    }
}
