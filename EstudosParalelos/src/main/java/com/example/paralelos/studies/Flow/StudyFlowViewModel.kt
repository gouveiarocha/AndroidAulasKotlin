package com.example.paralelos.studies.Flow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class StudyFlowViewModel : ViewModel() {

    val languagesData: LiveData<String> = getLanguages().asLiveData()

    fun getLanguages(): Flow<String> {

        val languages = listOf("Kotlin", "Java", "PHP", "Delphi", "C#", "JavaScript")

        // Bloco Flow para emitir os dados.
        // Ao retornar um flow, não precisamos especificar o tipo. Vamos trabalhar aqui.
        return flow {
            for (language in languages) {
                emit(language)
                delay(2000L)
            }
        }

    }

}