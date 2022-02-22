package com.example.app_convidados.service.constants

class DBConstants private constructor(){

    object GUEST {

        const val TABLE_NAME = "Guest"

        object COLUMNS{
            const val ID = "id"
            const val NAME = "name"
            const val PRESENCE = "presence"
        }

    }

}