package com.example.androidaulaskotlin.ActsApps.PortariaOO.business

import com.example.androidaulaskotlin.ActsApps.PortariaOO.entity.Invitation

class InvitationBusiness {

    fun isTypeValid(type: String) = (type == "comum" || type == "premium" || type == "luxo")

    fun isCodeValid(invitation: Invitation) = when (invitation.type) {
        "comum" -> invitation.code.startsWith("xt")
        "premium", "luxo" -> invitation.code.startsWith("xl")
        else -> false
    }

}