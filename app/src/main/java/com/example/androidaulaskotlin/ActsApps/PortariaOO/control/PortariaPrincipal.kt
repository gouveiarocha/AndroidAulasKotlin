package com.example.androidaulaskotlin.ActsApps.PortariaOO.control

import com.example.androidaulaskotlin.ActsApps.PortariaOO.business.InvitationBusiness
import com.example.androidaulaskotlin.ActsApps.PortariaOO.entity.Invitation

class PortariaPrincipal {

    private val conviteBusiness = InvitationBusiness()

    init {
        println("Portaria Inicializada...")
        println(controleAcesso())
    }

    private fun controleAcesso(): String {

        //Idade...
        val idade = PortariaConsole.readInt("Informar idade: ")
        if (idade < 18) {
            return "Acesso Negado. Menores de idade não são permitidos..."
        }

        //Tipo Convite...
        val invitationType = PortariaConsole.readString("Informe o tipo do convite: ")
        if (!conviteBusiness.isTypeValid(invitationType)) {
            return "Acesso Negado. Tipo de convite inválido..."
        }

        //Código Convite...
        val invitationCode = PortariaConsole.readString("Informe o código do convite: ")
        val invitation = Invitation(invitationType, invitationCode)
        if (!conviteBusiness.isCodeValid(invitation)) {
            return "Acesso Negado. Código do convite inválido..."
        }

        return "Acesso Liberado. Seja vem vindo..."

    }

}