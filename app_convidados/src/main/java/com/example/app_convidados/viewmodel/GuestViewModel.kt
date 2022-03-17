package com.example.app_convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.app_convidados.service.constants.GuestConstants
import com.example.app_convidados.service.model.GuestModel
import com.example.app_convidados.service.repository.GuestRepository

class GuestViewModel(application: Application) : AndroidViewModel(application) {

    private val mGuestRepository = GuestRepository.getInstance(application.applicationContext)

    private val _guestList = MutableLiveData<List<GuestModel>>()
    val guestList: LiveData<List<GuestModel>> = _guestList

    fun load(filter: Int) {
        when (filter){
            GuestConstants.FILTER.ALL -> _guestList.value = mGuestRepository.getAll()
            GuestConstants.FILTER.PRESENTS -> _guestList.value = mGuestRepository.getPresent()
            GuestConstants.FILTER.ABSENTS -> _guestList.value = mGuestRepository.getAbsents()
        }
    }

    fun delete(id: Int){
        mGuestRepository.delete(id)
    }

}