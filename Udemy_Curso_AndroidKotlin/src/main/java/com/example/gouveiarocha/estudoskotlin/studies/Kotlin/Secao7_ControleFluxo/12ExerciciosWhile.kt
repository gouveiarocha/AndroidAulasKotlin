package com.example.gouveiarocha.estudoskotlin.studies.Kotlin.Secao7_ControleFluxo

fun main() {
    exercicios(1)
    exercicios(2)
    exercicios(3, "Meu nome é Douglas")
    exercicios(4, "xxoooxxoxoo")

}

private fun exercicios(num: Int, str: String = "") {
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
        3 -> {
            var i = str.length - 1
            while (i >= 0) {
                print(str[i])
                i--
            }
        }
        4 -> {
            str.lowercase()
            var countX = 0
            var countO = 0
            var i = 0
            while (i <= (str.length - 1)) {
                if (str[i] == 'x') {
                    countX++
                }
                if (str[i] == 'o') {
                    countO++
                }
                i++
            }
            if (countX == countO) {
                println("True")
            } else {
                println("False")
            }
        }
    }
}