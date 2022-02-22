package com.example.app_convidados.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.app_convidados.service.model.GuestModel
import com.example.app_convidados.service.repository.GuestRepository

class GuestFormViewModel : ViewModel() {

    private val mGuestRepository: GuestRepository = GuestRepository()

    private val _saveGuest = MutableLiveData<Boolean>().apply {}
    val saveGuest = _saveGuest

    fun save(name: String, presence: Boolean) {
        val guest = GuestModel(name, presence)
        mGuestRepository.save(guest)
    }

}