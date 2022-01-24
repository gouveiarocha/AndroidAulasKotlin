package Secao15_Colecoes_Funcoes

/**
 * Set
 * A coleção Set não permite elementos duplicados, o que é uma característica muito útil.
 * Caso dois valores iguais sejam adicionados no Set, somente um deles será usado e não acontecerá erro.
 * */

fun main() {

    // Criação de Set com String e Int. Aceita qualquer tipo de dado.
    val set = setOf("Madrid", "São Paulo", "Berlim")
    val s11: Set<Int> = setOf(1)

    // Cria um set mutável com elementos repetidos
    val setMutavel = mutableSetOf(1, 2, 3, 4, 5, 5, 5, 5, 5, 5)

    // Imprime o set sem elementos repetidos
    println(setMutavel)
    println(setMutavel.size)


    // Adicionando mais elementos repetidos e imprimindo novamente
    setMutavel.add(5)
    setMutavel.add(5)
    setMutavel.add(5)
    setMutavel.add(5)

    // Elementos únicos - não repetidos
    println(setMutavel)

    // Removendo um valor
    setMutavel.remove(5)

    // Verifica se existe o elemento
    println(setMutavel.contains(5))

    // Limpando a coleção - Somente possível em mutável
    setMutavel.clear()
}