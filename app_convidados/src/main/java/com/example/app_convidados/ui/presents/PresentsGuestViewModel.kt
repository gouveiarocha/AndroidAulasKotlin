package com.example.app_convidados.ui.presents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PresentsGuestViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "PRESENTS GUESTS"
    }
    val text: LiveData<String> = _text
}