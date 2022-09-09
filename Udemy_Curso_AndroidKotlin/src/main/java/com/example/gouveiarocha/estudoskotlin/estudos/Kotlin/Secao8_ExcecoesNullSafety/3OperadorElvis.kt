package Secao8_Excecoes_NullSafety

/**
 * Operador Elvis : ?
 * Se a parte esquerda da expressão for nulo, retorna a parte da direita.
 */

fun main() {

    val str: String? = null

    // Verificação padrão
    if (str == null) {
        println("NULO")
    } else {
        println(str)
    }

    // Verificação com operado elvis
    println(str ?: "NULO")


    // TODO - Não existe operador ternário em Kotlin

    //Exemplo de operador ternario no java:
    //int idade = 18;
    //String str2 = (idade > 18) ? "Maior de Idade" : "Menor de Idade"

    //Mesmo exemplo no Kotlin: Lembrar que o if também funciona como expressão!
    var idade = 18;
    val str2 = if (idade > 18) "Maior de Idade" else "Menor de Idade"

}