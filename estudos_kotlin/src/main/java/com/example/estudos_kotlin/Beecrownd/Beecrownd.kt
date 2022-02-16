package com.example.gouveiarocha.estudoskotlin.Paralelos.Beecrownd

import java.text.DecimalFormat
import kotlin.math.pow

fun main() {

    //
    //println("Hello Word")

    //
    val area = Math.PI * 100.64.pow(2)
    val df = DecimalFormat("#####.####")
    println("A=${df.format(area)}")

}