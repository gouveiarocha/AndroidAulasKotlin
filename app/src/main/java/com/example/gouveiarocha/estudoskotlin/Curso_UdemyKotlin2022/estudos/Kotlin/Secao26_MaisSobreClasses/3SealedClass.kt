package com.example.gouveiarocha.estudoskotlin.Curso_UdemyKotlin2022.estudos.Kotlin.Secao26_MaisSobreClasses

/**
 * SealedClass ou Classe selada.
 * Serve para proibir que outras classes herdem ela mesma, com excessão das classes internas dela.
 * Observar o exemplo abaixo, onde conseguimos instanciar as classes e em seguida usar um when para
 * verificar o tipo da classe utilizada. 
 */

fun main() {

    val repo = Repo()
    val result = repo.execute()

    when (result) {
        is Result.Success -> println(result.message)
        is Result.Error -> println("Erro: ${result.message} ${result.errorCode}")
    }

}

sealed class Result {
    class Success(val message: String) : Result()
    class Error(val message: String, val errorCode: Int) : Result()
}

class Repo {
    fun execute(): Result {
        return if (true){
            Result.Success("Sucesso no execute...")
        } else {
            Result.Error("Erro no execute:", 404)
        }
    }
}

