package Secao14_OO2_Heranca.`8ClasseAnonima`

class Programa {
    fun salvar(event: Event) {
        println("Abrindo conexões.")
        println("Salvando valores.")
        println("Sucesso. Conexões fechadas.")
        event.onClose()
    }

}