package com.example.androidaulaskotlin.ActsApps.PortariaOO.control

import com.example.androidaulaskotlin.ActsApps.PortariaOO.business.GuestBusiness
import com.example.androidaulaskotlin.ActsApps.PortariaOO.entity.Guest

class PortariaPrincipal {

    private val guestBusiness = GuestBusiness()

    init {
        println("Portaria Inicializada...")
        println(controleAcesso())
    }

    private fun controleAcesso(): String {

        val guest = Guest()

        //Idade...
        guest.age = PortariaConsole.readInt("Informar idade: ")
        if (!guestBusiness.isOfAge(guest.age)) {
            return "Acesso Negado. Menores de idade não são permitidos..."
        }

        //Tipo Convite...
        guest.invitationType = PortariaConsole.readString("Informe o tipo do convite: ")
        if (!guestBusiness.isTypeValid(guest.invitationType)) {
            return "Acesso Negado. Tipo de convite inválido..."
        }

        //Código Convite...
        guest.invitationCode = PortariaConsole.readString("Informe o código do convite: ")
        if (!guestBusiness.isCodeValid(guest)) {
            return "Acesso Negado. Código do convite inválido..."
        }

        return "Acesso Liberado. Seja vem vindo..."

    }

}