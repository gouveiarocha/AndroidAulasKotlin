package com.example.androidaulaskotlin.ActsEstudos.Kotlin.Secao27_MaisSobreFuncoes2

/**
 * OperadorOverloading quando configurado dentro de uma classe, permite executarmos ações como
 * somar uma classe com a outra. Exemplo abaixo.
 */

fun main() {

    val f1 = Fraction(3, 2)
    val f2 = Fraction(3, 2)
    //f1 + f2 //não possivel

    var f3 = FractionWithOO(3, 2)
    val f4 = FractionWithOO(5, 3)

    println(f3 + f4) //possivel
    f3++ //possivel


}

class Fraction(val numerator: Int, val denominator: Int) {

}

data class FractionWithOO(val numerator: Int, val denominator: Int) {
    //ex soma
    operator fun plus(add: FractionWithOO): FractionWithOO {
        if (denominator == add.denominator) {
            return FractionWithOO(numerator + add.numerator, denominator)
        } else {
            val commum = denominator * add.denominator
            return FractionWithOO(
                ((commum / denominator) * numerator) + ((commum / add.denominator) * add.numerator), commum)
        }
    }
    //ex incremento
    operator fun inc(): FractionWithOO{
        return this
    }
}