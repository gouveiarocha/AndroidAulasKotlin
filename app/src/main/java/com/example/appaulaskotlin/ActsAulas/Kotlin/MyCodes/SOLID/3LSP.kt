package MyCodes.SOLID

/**
 * Liskov Substituion Principle - Principio da substituição de Linskov
 *  -Objetos da superclasse podem ser utilizados na subclasse sem erros no código.
 *  -Cuidado para nao violar o LSP, sobescrevendo ou implementando um metodo que não faz nada ou
 *  lançando uma exceção que não faz nada, ou até retornando valores de tipos diferentes da superclasse.
 *  -É preciso usar bem as abstrações da classe e utilizar injeção de dependencia, alem do OCP e do ISP
 *  -Usar bem o LSP permite usar o polimorfismo com maior eficiencia. Podemos usar as subclasses
 *  referindo a sua classe base sem se preocupar com resultados inesperados
 */

//Exemplo
open class A {
    open fun nameClass(): String {
        return "Meu nome é A"
    }
}

class B : A() {
    override fun nameClass(): String {
        return "Meu nome é B"
    }
}

//Observar que a fun pede um parametro do tipo A.
fun imprimeNome(objcA: A): String {
    return objcA.nameClass()
}

fun main() {

    val objctA = A()
    val objctB = B() //Objeto do tipo B

    println(imprimeNome(objctA))
    println(imprimeNome(objctB)) //E aqui a fun aceita passar um parametro do tipo B.

}