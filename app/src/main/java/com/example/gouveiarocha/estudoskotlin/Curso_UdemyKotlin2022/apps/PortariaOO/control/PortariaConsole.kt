package com.example.gouveiarocha.estudoskotlin.Curso_UdemyKotlin2022.apps.PortariaOO.control

class PortariaConsole private constructor() {

    companion object {

        //Escopo classe. Não precisa instancia-la para ter acesso as funções.

        fun readInt(msg: String): Int {
            var ret: Int? = null
            do {
                print(msg)
                val info = readLine()
                if (info != null && info != "") {
                    ret = info.toIntOrNull()
                    if (ret == null || ret <= 0) {
                        println("Valor inválido...")
                    }
                } else {
                    println("Valor inválido...")
                }
            } while (ret == null || ret <= 0)
            return ret
        }

        fun readString(msg: String): String {
            var ret: String? = null
            do {
                print(msg)
                val info = readLine()
                if (info != null && info != "") {
                    ret = info.lowercase()
                } else {
                    println("Valor inválido...")
                }
            } while (ret == null)
            return ret
        }

    }

}