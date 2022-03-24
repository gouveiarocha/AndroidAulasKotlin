package com.example.app_convidados.service.repository.room

import android.content.Context
import com.example.app_convidados.service.model.GuestModel

class GuestRepositoryRoom (context: Context) {

    private val mDatabase = GuestDatabase.getDatabase(context).guestDAO()

    /**
     * CRUDS
     */

    fun save(guest: GuestModel): Boolean {
        return mDatabase.save(guest) > 0
    }

    fun update(guest: GuestModel): Boolean {
        return  mDatabase.update(guest) > 0
    }

    fun delete(guest: GuestModel) {
        mDatabase.delete(guest)
    }

    /**
     * FILTERS
     */

    fun get(id: Int): GuestModel {
        return mDatabase.get(id)
    }

    fun getAll(): List<GuestModel> {
        return mDatabase.getInvited()
    }

    fun getPresent(): List<GuestModel> {
        return mDatabase.getPresent()
    }

    fun getAbsents(): List<GuestModel> {
        return mDatabase.getAbsent()
    }

}