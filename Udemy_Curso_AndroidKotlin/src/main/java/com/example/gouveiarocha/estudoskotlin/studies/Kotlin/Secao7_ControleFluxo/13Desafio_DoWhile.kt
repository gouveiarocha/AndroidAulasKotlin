package com.example.gouveiarocha.estudoskotlin.studies.Kotlin.Secao7_ControleFluxo

fun main() {

    val salario = 10000f
    var patrimonioAna = 0f
    var patrimonioPaula = 0f
    var mes = 0

    do {

        // Patrimonio da Ana
        patrimonioAna += (salario * 0.05f) + (salario * 0.05f) + (patrimonioAna * 0.002f)

        // Patrimonio da Paula
        patrimonioPaula += (salario * 0.05f) + (patrimonioPaula * 0.008f)

        mes++

    } while (patrimonioAna > patrimonioPaula)

    println("Patrimonio Ana: $patrimonioAna")
    println("Patrimonio Paula: $patrimonioPaula")
    println("Paula passa o patrimonio de Ana no mês $mes")
    println("Anos que isso vai demorar: ${mes / 12}")

}