package com.devmasterteam.tasks.service.model

/*
 * Breve explicação sobre essa classe
 * Caso criemos uma instancia sem passar nada no parametro, o status será true e a msg será vazia.
 * Caso passamos uma msg, o if verifica e se a msg for diferente de nula, atribui false para o status.
 * Também criamos duas funs para retornar o status e a msg, assim não expomos diretamente os nossos
 * atributos
 */

class ValidationModel(message: String = "") {

    private var status: Boolean = true
    private var validationMessage: String = ""

    init {
        if (message != ""){
            validationMessage = message
            status = false
        }
    }

    fun status() = status
    fun message() = validationMessage

}