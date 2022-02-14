package com.example.gouveiarocha.estudoskotlin.Paralelos.EstudosFaculdade

/**
 * Práticas algoritimo e lógica de programação.
 */

fun main() {

    //println(calculateOccupancyPercentage())
    countNumberLetters("Exemplo de frase para contar a quantidade de letras...")

}

fun calculateOccupancyPercentage(): String {

    /**
     * O plano diretor de desenvolvimento urbano de uma cidade determina qual é o
    percentual máximo de área destinado para garagem em relação à área total do terreno da
    casa, dependendo da localização desse terreno na cidade. Uma empresa de arquitetura
    está com vários contratos e necessita calcular rapidamente esse percentual, antes de iniciar
    os projetos. Faça um programa que recebe as medidas do terreno e da garagem e calcula
    o percentual de ocupação da área da garagem em relação ao terreno.
     */

    val zone = "N"

    var widhtGarage = 5.0 //user input
    var depthGarage = 6.0 //user input
    val areaGarage = widhtGarage * depthGarage

    var widthGround = 20.0 //user input
    var depthGround = 20.0 //user input
    val areaGround = widthGround * depthGround

    val occupancyPercentage = (areaGarage / areaGround) * 100

    val approved =
        "Percentual de ocupação da garagem: $occupancyPercentage% - Projeto atende as normas  de zoneamento do plano diretor. Aprovado."
    val notApproved =
        "Percentual de ocupação da garagem: $occupancyPercentage% - Projeto não atende as normas  de zoneamento do plano diretor. Revisar medidas."
    if (zone == "N" && occupancyPercentage <= 25) {
        return approved
    } else if ((zone == "L" || zone == "W") && occupancyPercentage <= 30) {
        return approved
    } else if (zone == "S" && occupancyPercentage <= 40) {
        return approved
    } else {
        return notApproved
    }

}

fun countNumberLetters(phrase: String) {

    /**
     * Contar quantidade de letras manualmente com o for
     * Obs: No enunciado da apostila, informa quantidade de letras e calcula a quantidade de caracteres,
     * uma vez que caracter em branco não deve ser considerado letra, ajustei o algoritimo para contar,
     * somente as letras:
     */

    var amountLetters = 0

    for (i in phrase) {
        if (i.isLetter()){
            amountLetters++
        }
    }

    println("Quantidade de letras na frase informada: $amountLetters")

}