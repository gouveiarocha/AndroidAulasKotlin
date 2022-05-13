package com.example.gouveiarocha.estudoskotlin.estudos.MVVM

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MVVMVielModel : ViewModel() {

    private var mRepository = PersonRepository()

    private var mTextWelcome = MutableLiveData<String>()
    var textWelcome = mTextWelcome

    private var mLogin = MutableLiveData<Boolean>()
    var login = mLogin

    init {
        mTextWelcome.value = "Hello Word!"
    }

    fun doLogin(login: String) {
        val ret = mRepository.login(login)
        mLogin.value = ret
    }

}