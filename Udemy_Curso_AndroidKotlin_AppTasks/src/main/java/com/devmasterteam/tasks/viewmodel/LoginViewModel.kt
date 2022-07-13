package com.devmasterteam.tasks.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devmasterteam.tasks.service.constants.TaskConstants
import com.devmasterteam.tasks.service.listener.APIListener
import com.devmasterteam.tasks.service.model.PersonModel
import com.devmasterteam.tasks.service.model.ValidationModel
import com.devmasterteam.tasks.service.repository.PersonRepository
import com.devmasterteam.tasks.service.repository.SecurityPreferences
import com.devmasterteam.tasks.service.repository.remote.RetrofitClient

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val personRepository = PersonRepository(application.applicationContext)
    private val securityPreferences = SecurityPreferences(application.applicationContext)

    private val _login = MutableLiveData<ValidationModel>()
    var login: LiveData<ValidationModel> = _login

    // Verifica se o usuário já esta logado.
    fun verifyLoggedUser() {

    }

    // Faz Login usando a API.
    fun doLogin(email: String, password: String) {
        personRepository.login(email, password, object : APIListener<PersonModel>{
            override fun onSuccess(result: PersonModel) {
                saveHeaders(result)
                RetrofitClient.addHeaders(result.token, result.personKey)
                _login.value = ValidationModel()
            }
            override fun onFailure(message: String) {
                _login.value = ValidationModel(message)
            }
        })
    }

    private fun saveHeaders(result: PersonModel) {
        securityPreferences.store(TaskConstants.SHARED.TOKEN_KEY, result.token)
        securityPreferences.store(TaskConstants.SHARED.PERSON_KEY, result.personKey)
        securityPreferences.store(TaskConstants.SHARED.PERSON_NAME, result.name)
    }

}