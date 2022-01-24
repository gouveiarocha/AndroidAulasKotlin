package com.example.appaulaskotlin.ActsEstudos.Kotlin.Secao26_MaisSobreClasses

/**
 * NestedClass do Kotlin funciona como a InnerClass do java. Observar que, caso seja uma inner class
 * a forma de instanciar é diferente.
 * Observar também que, com a inner class declarada, é possivel acessar as propriedades da classe principal.
 */

fun main() {

    val memoria1 = Computador("Intel").Memoria() //inner class
    //val memoria2 = Computador.Memoria() //classe normal
    memoria1.getMemoryLevel()

}

class Computador(val modeloProcessador: String){

    inner class Memoria {

        fun getMemoryLevel(): Int{
            println(modeloProcessador)
            return 70
        }

    }

}