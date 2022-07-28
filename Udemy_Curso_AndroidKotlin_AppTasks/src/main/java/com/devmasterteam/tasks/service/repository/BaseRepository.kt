package com.devmasterteam.tasks.service.repository

import com.google.gson.Gson

open class BaseRepository {
    fun failReponseFromJson(jsonString: String): String {
        return Gson().fromJson(jsonString, String::class.java)
    }
}