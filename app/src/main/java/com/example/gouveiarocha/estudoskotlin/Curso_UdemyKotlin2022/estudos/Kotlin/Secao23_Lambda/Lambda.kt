package com.example.gouveiarocha.estudoskotlin.Curso_UdemyKotlin2022.estudos.Kotlin.Secao23_Lambda

//Lambda -> Função anônima ->
//Estrutura: { parametros -> corpo }

fun main() {

    //1º ex
    val a = { println("Hello") }
    a()
    receiveA(a)

    //outra forma de implementar o codigo acima:
    receiveA { println("Hello") }

    //2º ex
    val b = { x: Int -> x * x }
    b(10)
    receiveB { b(125) }

    //observar, a última linha do corpo define se é uma lambda ou um unit
    //o lambda possui um retorno valido, se tentarmos associar o c() do 3º ex a uma String, irá dar
    //erro, pois é um lambda retornando um int.

    //3º ex(lambda)
    val c = { x: Int, y: Int ->
        println("Executando...")
        x + y
    }
    receiveC(c)

    //val teste: String = c(10,10) //erro
    val teste2: Int = c(10, 10) //ok

    //4º ex(unit)
    val d = { x: Int, y: Int ->
        println("Executando...")
        x + y
        println("Terminou...")
    }

}

fun abc(x: Int) {}

//Exemplos de lambda com parametros

// () -> Unit
fun receiveA(lambda: () -> Unit) {
    lambda()
}

fun receiveB(bb: (x: Int) -> Int) {
}

fun receiveC(cc: (b1: Int, b2: Int) -> Int) {}

