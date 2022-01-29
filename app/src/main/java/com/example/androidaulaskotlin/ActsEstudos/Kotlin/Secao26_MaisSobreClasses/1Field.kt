package Secao26_MaisSobreClasses

import java.io.Serializable
import java.lang.Exception

fun main() {

    val carro1 = Carro("Palio", 220)
    //carro1.currentSpeed = 100
    carro1.currentSpeed2 = 250
    carro1.imprimir()

}


// --------Classe Carro--------- //

class Carro(val modelo: String, val maxSpeed: Int): Serializable {

    //--->propriedade privada
    var currentSpeed: Int = 0
        private set

    //--->usando o field para atribuir a propriedade
    var currentSpeed2: Int = 0
        set(value) {
            if (value > maxSpeed) {
                throw Exception("Velocidade maior que a permitida...")
            } else {
                //this.currentSpeed2 = value --> Loop infinito. Devemos usar field
                field = value
            }
        }

    fun imprimir() {
        println("Modelo: $modelo - Velocidade Máxima: $maxSpeed")
    }

}

