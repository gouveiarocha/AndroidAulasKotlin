package com.example.androidaulaskotlin.UdemyKotlin.estudos.TU

import countXO
import org.junit.jupiter.api.*
import throwException
import java.lang.NullPointerException

class TesteUnitarioTest {

    @Test
    @DisplayName("Funcionamento XO")
    fun testeCountXO() {

        //Quando existem váris assertions, se uma falhar, as outras não são executadas.
        Assertions.assertTrue(countXO("xxoo")) //testar true
        Assertions.assertTrue(countXO("XXOO")) //testar true
        Assertions.assertTrue(countXO("xxOO")) //testar true
        Assertions.assertTrue(countXO("XXoo")) //testar true
        Assertions.assertEquals(countXO("xxoo"), true) //outra forma de testar true

        //Exemplo para testar todos os métodos, sem interromper caso algum ocorra erro.
        Assertions.assertAll(
            { Assertions.assertTrue(countXO("xxoo")) },
            { Assertions.assertTrue(countXO("XXOO")) },
        )

    }

    @Test
    @Disabled("Ainda não finalizadoo")
    fun naoImplementado(){

    }

    @Test
    fun naoImplementadoMasInvalido(){
        fail("Ainda não finalizado")
    }

    @Test
    @Disabled("Roda baseado em condicão")
    fun rodaSomenteBaseadoEmCondicao() {
        //Suposição
        Assumptions.assumeTrue(countXO("xxoo"))
        //Assumptions.assumeFalse(countXO("xxoo"))

        //Resto do código só é executado se a suposição se mostrar como verdadeira
        Assertions.assertEquals(true, countXO("xxoo"))
    }

    @Test
    @DisplayName("Teste lancamento de excecao")
    fun lancaExcecao() {

        assertThrows<IndexOutOfBoundsException> {
            throw IndexOutOfBoundsException("Index fora do array.")
        }

        assertThrows<NullPointerException> { throwException() }
    }

    @Test
    @DisplayName("Teste de não nulo.")
    fun testNotNull() {
        //Testa se o retorno da função é diferente de nulo.
        Assertions.assertNotNull(countXO("xo"))

        //Muito cuidado em cenários desse tipo, pois pode ser que a função
        //nunca tenha o retorno nulo. Nesse caso, esse teste nunca falha,
        //mesmo que a função esteja com comportamento incorreto.
    }

}