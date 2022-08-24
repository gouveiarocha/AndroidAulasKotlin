package com.example.gouveiarocha.estudoskotlin.estudos.Kotlin.Secao7_ControleFluxo

fun main() {
    exercicios(2)
}

private fun exercicios(num: Int) {
    when (num) {
        1 -> {
            val capCaixa = 2000
            val capBalao = 7
            var qtdBaloes = 0
            while ((qtdBaloes * capBalao) + capBalao < capCaixa) {
                qtdBaloes++
            }
            println("Cabem $qtdBaloes na caixa d'água.")
        }
        2 -> {
            var i = 1
            while (i <= 50) {
                if (i % 3 == 0 && i % 5 == 0) {
                    print("FizzBuzz ")
                } else if (i % 3 == 0) {
                    print("Buzz ")
                } else if (i % 5 == 0) {
                    print("Fizz ")
                } else {
                    print("$i ")
                }
                i++
            }
        }
    }
}