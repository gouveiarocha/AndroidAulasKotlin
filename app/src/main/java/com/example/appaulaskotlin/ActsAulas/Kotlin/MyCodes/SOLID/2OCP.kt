package MyCodes.SOLID

/**
 * O = Open-Closed Principle - Principio Aberto-Fechado - Parecido com o Design Pattern Strategy
 *  -Objetos devem estar abertos para extenção mas fechados para modificação.
 *  -Utilizar interfaces para implementar novas alterações ao codigo, evitando modificar o codigo ja existente.
 */

//Primeiro código, violando o OCP
class ContratoClt {}
class ContratoEstagio {}
class FolhaDePagamento(val contract: String) { //Entenda o contrato como a classe de referencia
    private var saldo = 0
    fun calcularPagamento() {
        //O if esta separando a logica pelo tipo de contratação. É possivel melhorar usando o OCP
        if (contract == "ContratoClt") {
            //Lógica para CLT.
        } else if (contract == "ContratoEstagio") {
            //Lógica para Estagio.
        }
    }
}

//Mesmo código refatorado usando OCP - Agora vamos aplicar a regra de negocio implementando uma interface
//Facil de testar e implementar novas funcões, como a regra de negocio para Pessoa Juridica.
fun main() {
    val folhaDePagamento = FolhaDePagamentoOCP() //Objeto folha de pagamento.
    val tipoContrato = ContratoJuridicaOCP() //Interface Pessoa Juridica, que tem o proprio metodo de remuneração
    folhaDePagamento.calcularPagamento(tipoContrato) //Calcula o pagamento de acordo com o tipo de contrato.
}

interface Remuneravel {
    fun remuneracao(): Float
}

class ContratoCltOCP : Remuneravel {
    override fun remuneracao(): Float {
        //lógica para contrato CLT
        return 100f
    }
}

class ContratoEstagioOCP : Remuneravel {
    override fun remuneracao(): Float {
        //lógica para contrato Estagio
        return 50f
    }
}

class ContratoJuridicaOCP : Remuneravel {
    override fun remuneracao(): Float {
        //lógica para contrato PPJ
        return 150f
    }
}

class FolhaDePagamentoOCP() { //Entenda o contrato como a classe de referencia
    private var saldo: Float = 0f
    fun calcularPagamento(iRemuneracao: Remuneravel) {
        this.saldo = iRemuneracao.remuneracao()
        println(this.saldo)
    }
}

