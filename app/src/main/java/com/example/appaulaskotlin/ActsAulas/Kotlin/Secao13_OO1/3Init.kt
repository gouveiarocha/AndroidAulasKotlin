package Secao13_OO1

import java.util.*

fun main() {

    val nina = Animal("Cachorro")

}

class Animal(val especie: String) {

    var fala: String = ""

    //Bloco init
    init {
        fala = if (especie.lowercase() == "cachorro") {
            "au"
        } else if (especie.lowercase() == "gato") {
            "miau"
        } else {
            ""
        }
    }

    init {
        println(fala)
    }

}

class Funcionario(val nome: String) {

    var tipoContrato: String = ""

    //Bloco init
    init {
        tipoContrato = "CLT"
    }

}