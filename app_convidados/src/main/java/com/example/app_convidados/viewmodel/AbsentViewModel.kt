package com.example.app_convidados.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AbsentViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "ABSENTS GUEST"
    }
    val text: LiveData<String> = _text
}