package Secao8_Excecoes_NullSafety

fun main() {

    // O bloco dentro do let só é executado se o valor é diferente de nulo
    // O bloco let cria algo chamado "scope function" que é basicamente um escopo específico
    // para o objeto referenciado, no caso "str".
    // Dentro do bloco let, a referência ao objeto passa a ser "it".

    convencional()
    let()

}

//conceito convencional
fun convencional(){
    //conceito normal
    val nome= "Douglas"
    if (nome != null && nome != "") {
        println(nome)
    }
    //com let
    nome.let {
        println(it.uppercase())
    }
}

//conceito com let
fun let(){

    var str2: String? = null
    str2 = "teste"
    str2?.let {
        println("Scope Function")
        it.uppercase()
        it.length
    }

}