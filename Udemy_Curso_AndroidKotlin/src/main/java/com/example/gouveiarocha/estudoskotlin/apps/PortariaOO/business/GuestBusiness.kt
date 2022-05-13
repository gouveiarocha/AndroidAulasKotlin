package com.example.gouveiarocha.estudoskotlin.apps.PortariaOO.business

import com.example.gouveiarocha.estudoskotlin.apps.PortariaOO.entity.Guest

class GuestBusiness {

    fun isOfAge(age: Int) = age >= 18

    fun isTypeValid(type: String) = (type == "comum" || type == "premium" || type == "luxo")

    fun isCodeValid(guest: Guest) = when (guest.invitationType) {
        "comum" -> guest.invitationCode.startsWith("xt")
        "premium", "luxo" -> guest.invitationCode.startsWith("xl")
        else -> false
    }

}