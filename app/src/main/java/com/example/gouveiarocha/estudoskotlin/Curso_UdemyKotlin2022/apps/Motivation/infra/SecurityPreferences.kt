package com.example.gouveiarocha.estudoskotlin.Curso_UdemyKotlin2022.apps.Motivation.infra

import android.content.Context

open class SecurityPreferences(context: Context) {

    private val mPreference = context.getSharedPreferences("motivation", Context.MODE_PRIVATE)

    fun storeString(key:String, value:String){
        mPreference.edit().putString(key, value).apply()
    }

    fun getString(key: String) : String {
        return mPreference.getString(key, "") ?: "" //operador elvis
    }

}