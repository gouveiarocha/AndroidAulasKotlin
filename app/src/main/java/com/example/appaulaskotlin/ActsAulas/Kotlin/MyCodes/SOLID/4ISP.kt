package MyCodes.SOLID

/**
 *  I = Interface Segregation Principle - Principio da segregação da Interface
 *   -Classe não deve ser forçada a implementar interfaces e metodos que não irá utilizar.
 *   -Melhor criar interfaces mais especificas do que uma mais genérica
 */

//Primeiro codigo, vamos violar a ISP
interface Aves {
    fun setLocalizacao()
    fun setAltitude()
    fun renderizar()
}

class Papagaio() : Aves {
    override fun setLocalizacao() {
        TODO("Not yet implemented")
    }
    override fun setAltitude() {
        TODO("Not yet implemented")
    }
    override fun renderizar() {
        TODO("Not yet implemented")
    }
}

class Pinguim() : Aves {
    override fun setLocalizacao() {
        TODO("Not yet implemented")
    }
    override fun setAltitude() {
        TODO("Not yet implemented")
    } //Opa!!!!! Pinguim não voa. Aqui esta violação do ISP.
    override fun renderizar() {
        TODO("Not yet implemented")
    }
}

//Agora refatorar respeitando a ISP
//Observar que agora, adicionando mais uma camada de interface, o pinguim não possui mais o fun setAltitude
interface AvesISP {
    fun setLocalizacao()
    fun renderizar()
}

interface AvesQueVoam : AvesISP {
    fun setAltitude()
}

class PapagaioISP() : AvesQueVoam {
    override fun setLocalizacao() {
        TODO("Not yet implemented")
    }
    override fun renderizar() {
        TODO("Not yet implemented")
    }
    override fun setAltitude() {
        TODO("Not yet implemented")
    }
}

class PinguimISP() : AvesISP {
    override fun setLocalizacao() {
        TODO("Not yet implemented")
    }
    override fun renderizar() {
        TODO("Not yet implemented")
    }
}
