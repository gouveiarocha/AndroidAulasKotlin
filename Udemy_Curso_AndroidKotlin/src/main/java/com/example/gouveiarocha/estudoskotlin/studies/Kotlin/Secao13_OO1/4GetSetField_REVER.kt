package Secao13_OO1

fun main() {

    val eu = MinhaClasse()
    //eu.nome = "Douglas"
    //eu.idade = 31
    eu.imprimirDados()

}

class MinhaClasse(){

    private var nome: String? = null
    private var idade: Int? = null

    get() {
        return field
    }

    set(value) {
        field = value
    }

    fun imprimirDados(){
        println("Nome: $nome e tenho $idade anos")
    }

}

class Planeta {

    private var nome: String = ""

        get() {

            // Acesso a propriedade diretamente causa recursão
            // println("Meu valor é $nome")
            // return nome

            // Maneira correta
            println("Meu valor é $field")
            return field

        }

        set(value) {
            if (value == "") {
                println("Todo planeta deve ter um nome.")
            } else {

                // Acesso a propriedade diretamente causa recursão
                // nome = value

                // Maneira correta
                field = value
            }

        }

}