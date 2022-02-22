package com.example.app_convidados.service.repository

import com.example.app_convidados.service.model.GuestModel
import java.util.ArrayList

class GuestRepository {

    //CRUDS

    fun save(guest: GuestModel) {

    }

    fun update(guest: GuestModel) {

    }

    fun delete(guest: GuestModel) {

    }

    //FILTERS

    fun guestAll(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        //logic
        return list
    }

    fun guestPresents(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        //logic
        return list
    }

    fun guestAbsents(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        //logic
        return list
    }

}