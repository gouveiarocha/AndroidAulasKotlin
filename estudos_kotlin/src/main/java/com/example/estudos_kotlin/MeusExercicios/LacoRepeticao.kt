package com.example.estudos_kotlin.MeusExercicios


fun main() {

    //Ler um valor inteiro (aceitar somente valores entre 1 e 10) e escrever a tabuada de 1 a 10 do valor lido.

    //Fazer um programa para encontrar todos os números pares entre 1 e 100.
    //findEvenNumbers()

    //Escrever um programa para exibir os números de 1 até 50 na tela.
    //writeOneToFifty()

}

fun findEvenNumbers() {
    for (i in 1..100) if (i % 2 == 0) print("$i ")
}

fun writeOneToFifty() {
    for (i in 0..50) {
        print("$i ")
    }
}
