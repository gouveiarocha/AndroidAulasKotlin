package com.example.gouveiarocha.estudoskotlin.Livro_KotlinEmAcao

/*** pag. 27 */

//classe Person, recebe um nome e uma idade do tipo Int? (nullable) e o valor default
data class Person(val name: String, val age: Int? = null) {}

val persons = listOf(
    Person("Alice"),
    Person("Bob", 50)
)

fun main(args: Array<String>) { //função de nivel superior

    //expressão lambda
    val oldest = persons.maxByOrNull {
        it.age ?: 0 //operador elvis (que devolve 0 se age for null)
    }
    println("The oldest is $oldest") //toString automático

    println("---------------------------------------------------------------------------")

    //segurança com tratamentos de variaveis null
    val s: String? = null   //pode ser null
    val s2: String = ""     //não pode ser null

    if (s is String){ //aqui usamos o is, que é uma palavra reservado do kotlin que facilita a verificação.
        println(s)
    }

}

fun findPerson() {

}

//fun findAlice() = findPerson { it.name == "Alice" }
//fun findBob() = findPerson { it.name == "Alice" }