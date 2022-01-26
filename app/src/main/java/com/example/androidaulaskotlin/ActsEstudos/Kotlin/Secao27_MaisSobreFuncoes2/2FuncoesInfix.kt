package com.example.androidaulaskotlin.ActsEstudos.Kotlin.Secao27_MaisSobreFuncoes2

/**
 * Operador infix permite fazer comparações facilmente em classes mais simples. Exemplos abaixo.
 */

fun main() {

    //Sem infix
    10.isHalfOf(20)

    //Com infix, permite escrever assim:
    10 isHalfOfWithInfix 20

    //Exemplo usando Classe.
    val p1 = Person("Douglas")
    p1.isName("Douglas") //sem infix
    p1 isName "Douglas" //com infix

}

class Person(val name: String){
    infix fun isName(value: String):Boolean{
        return value == name
    }
}

//Função que extende a classe Int
fun Int.isHalfOf(value: Int) = value / 2 == this

//Com infix
infix fun Int.isHalfOfWithInfix(value: Int) = value / 2 == this

//Com infix, não é possivel ter mais de 1 parametro.
//infix fun Int.isHalfOfWithInfix2(value: Int, value2: Int) = value / 2 == this //erro compilação