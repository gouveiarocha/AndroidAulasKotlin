package com.example.gouveiarocha.estudoskotlin.studies.MVVM

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MVVMVielModel : ViewModel() {

    //LiveDatas
    private var mTextWelcome = MediatorLiveData<String>()
    private var mLogin = MutableLiveData<Boolean>()

    private var mRepository = PersonRepository()

    //Init para testar o exemplo com text welcome.
    init {
        mTextWelcome.value = "Hello Word!"
    }

    fun welcome(): MediatorLiveData<String> {
        return mTextWelcome
    }

    fun login(): MutableLiveData<Boolean> {
        return mLogin
    }

    fun doLogin(login: String) {
        val ret = mRepository.login(login)
        mLogin.value = ret
    }

}