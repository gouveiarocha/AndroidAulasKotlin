package com.devmasterteam.tasks.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devmasterteam.tasks.service.constants.TaskConstants
import com.devmasterteam.tasks.service.listener.APIListener
import com.devmasterteam.tasks.service.model.PersonModel
import com.devmasterteam.tasks.service.model.PriorityModel
import com.devmasterteam.tasks.service.model.ValidationModel
import com.devmasterteam.tasks.service.repository.PersonRepository
import com.devmasterteam.tasks.service.repository.PriorityRepository
import com.devmasterteam.tasks.service.repository.SecurityPreferences
import com.devmasterteam.tasks.service.repository.remote.RetrofitClient

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val personRepository = PersonRepository(application.applicationContext)
    private val priorityRepository = PriorityRepository(application.applicationContext)
    private val securityPreferences = SecurityPreferences(application.applicationContext)

    private val _login = MutableLiveData<ValidationModel>()
    var login: LiveData<ValidationModel> = _login

    private val _loggedUser = MutableLiveData<Boolean>()
    var loggedUser: LiveData<Boolean> = _loggedUser

    // Verifica se o usuário já está logado.
    fun verifyLoggedUser() {

        val token = securityPreferences.get(TaskConstants.SHARED.TOKEN_KEY)
        val personKey = securityPreferences.get(TaskConstants.SHARED.PERSON_KEY)

        RetrofitClient.addHeaders(token, personKey)

        val logged = (token.isNotEmpty() && personKey.isNotEmpty())
        _loggedUser.value = logged

        // Baixando a lista de prioridades.
        if (!logged) {
            priorityRepository.list(object : APIListener<List<PriorityModel>> {
                override fun onSuccess(result: List<PriorityModel>) {
                    priorityRepository.save(result)
                }

                override fun onFailure(message: String) {
                    Toast.makeText(getApplication(), message, Toast.LENGTH_SHORT).show()
                }
            })
        }

    }

    // Faz Login usando a API.
    fun doLogin(email: String, password: String) {
        personRepository.login(email, password, object : APIListener<PersonModel> {
            override fun onSuccess(result: PersonModel) {
                savePreference(result)
                RetrofitClient.addHeaders(result.token, result.personKey)
                _login.value = ValidationModel()
            }

            override fun onFailure(message: String) {
                _login.value = ValidationModel(message)
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