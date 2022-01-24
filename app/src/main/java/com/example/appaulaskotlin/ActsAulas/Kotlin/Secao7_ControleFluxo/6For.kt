package Secao7_ControleFluxo

fun main() {

    //crescente
    for (i in 0..20) {
        print("$i ")
    }

    println()
    println("-------------")

    //
    for (i in 20 downTo 0 step 2) {
        print("$i ")
    }

    println()
    println("-------------")

    for (c in "Curso de Kotlin") {
        print("$c ")
    }

    println()
    println("-------------")

}