package com.example.app_convidados.service.constants

class GuestConstants private constructor() {

    companion object {
        const val ID = "guestId"
    }

    object FILTER {
        const val ALL = 0
        const val PRESENTS = 1
        const val ABSENTS = 2
    }

}