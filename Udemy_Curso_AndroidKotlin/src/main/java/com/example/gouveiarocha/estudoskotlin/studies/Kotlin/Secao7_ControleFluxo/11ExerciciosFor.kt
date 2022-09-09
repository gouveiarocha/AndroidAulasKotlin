package com.example.gouveiarocha.estudoskotlin.studies.Kotlin.Secao7_ControleFluxo

fun main() {
    exercicios(5, 5)
}

private fun exercicios(numeroExercicio: Int, tamanhoEscada: Int = 0) {
    when (numeroExercicio) {
        1 -> {
            for (i in 1..50) {
                print("$i ")
            }
        }
        2 -> {
            for (i in 50 downTo 1) {
                print("$i ")
            }
        }
        3 -> {
            for (i in 1..50) {
                if (i % 5 != 0) {
                    continue
                }
                print("$i ")
            }
        }
        4 -> {
            var num = 0
            for (i in 1..500) {
                num += i
            }
            print(num)
        }
        5 -> {
            if (tamanhoEscada != 0) {
                for (i in 1..tamanhoEscada) {
                    for (i in 1..i) {
                        print("#")
                    }
                    println()
                }
            }
        }
    }
}
