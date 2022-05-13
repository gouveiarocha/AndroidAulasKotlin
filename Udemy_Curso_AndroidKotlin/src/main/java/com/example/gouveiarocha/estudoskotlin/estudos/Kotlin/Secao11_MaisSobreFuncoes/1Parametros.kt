package Secao11_MaisSobreFuncoes

/**
 * Funções podem ter parâmetros default - Caso não informados, assume o valor especificado.
 */

fun main() {

    //no ex abaixo, nao informamos o cep
    endereco("Das Flores", "São Paulo", "SP")

    //no ex abaixo, declaramos o parametro em ordem diferente, lembrando que, se começar dessa forma, todos os demais devem seguir da mesma forma
    endereco(estado = "SP", rua = "Das Flores")

}

//Obsevar: os parametros cidade e cep não precisam ser informados
fun endereco(rua: String, cidade: String = "", estado: String, cep: String = "") {
    println("Rua: $rua")
    println("Cidade: $cidade, $estado - $cep")
}