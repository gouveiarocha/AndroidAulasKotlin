package Secao8_Excecoes_NullSafety

import java.lang.ArithmeticException
import java.lang.Exception
import java.lang.NullPointerException

fun main() {

    try {

        val str: String? = null
        println(str!!.length) // NullPointerException
        //println(12 / 0) // ArithmeticException

    } catch (e: ArithmeticException) {
        println("Erro - Divisão por Zero!")
    } catch (e: NullPointerException) {
        println("Erro - NullPointer!")
    } catch (e: Exception) {
        println("Tivemos um Problema.")
    } finally {
        // o bloco finally sempre vai executar!
        println("Finalmente!")
    }

}