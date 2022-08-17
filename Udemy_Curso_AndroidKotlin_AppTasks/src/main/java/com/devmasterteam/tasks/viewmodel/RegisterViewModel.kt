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

class RegisterViewModel(application: Application) : AndroidViewModel(application) {

    private val personRepository = PersonRepository(application.applicationContext)
    private val securityPreferences = SecurityPreferences(application.applicationContext)

    private val _user = MutableLiveData<ValidationModel>()
    var user: LiveData<ValidationModel> = _user

    // Cria o Usuario usando a API.
    fun doCreate(name: String, email: String, password: String) {
        personRepository.create(name, email, password, object : APIListener<PersonModel> {
            override fun onSuccess(result: PersonModel) {
                savePreference(result)
                RetrofitClient.addHeaders(result.token, result.personKey)
                _user.value = ValidationModel()
            }

            override fun onFailure(message: String) {
                _user.value = ValidationModel(message)
            }

        })
    }

    // Salva os dados do usuário no SharedPreference.
    private fun savePreference(result: PersonModel) {
        securityPreferences.store(TaskConstants.SHARED.TOKEN_KEY, result.token)
        securityPreferences.store(TaskConstants.SHARED.PERSON_KEY, result.personKey)
        securityPreferences.store(TaskConstants.SHARED.PERSON_NAME, result.name)
    }

}