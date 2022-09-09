package com.example.gouveiarocha.estudoskotlin.estudos.Kotlin.Secao23_Lambda.LambdaOuAnonima

//Lambda ou Classe Anonima?!

class Form {
    fun clickJava(e: EventListenerJava) {}
    fun clickKotlin(e: EventListenerKotlin) {}
}

class Main {

    private val name = "Douglas"

    fun main() {

        //SAM Conversion - Single Abstract Method - Quando a interface implementada tem somente um método,
        // o Kotlin percebe e sugere a conversão para lambda. Isso só vai ocorrer a interface
        // tenha apenas um método.
        Form().clickJava {
            this.name //observe que o lambda, por baixo dos panos, tem acesso a propriedade da classe
            print("Hello")
        }

        //classe anonima
        Form().clickKotlin(object : EventListenerKotlin {
            override fun click() {
                //this.nome //já aqui não temos acesso pois se trata de uma classe anonima,
                // ou seja, um novo escopo da classe EventListenerKotlin.
            }
        })

    }
}