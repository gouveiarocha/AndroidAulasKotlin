package com.example.app_convidados.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.app_convidados.service.model.GuestModel
import com.example.app_convidados.service.repository.GuestRepository
import com.example.app_convidados.view.listener.GuestListener

class AllGuestViewModel(application: Application) : AndroidViewModel(application) {

    private val mGuestRepository = GuestRepository.getInstance(application.applicationContext)

    private val _guestList = MutableLiveData<List<GuestModel>>()
    val guestList: LiveData<List<GuestModel>> = _guestList

    fun load() {
        _guestList.value = mGuestRepository.getAll()
    }

}