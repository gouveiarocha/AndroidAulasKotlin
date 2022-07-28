package com.devmasterteam.tasks.service.repository

import com.devmasterteam.tasks.service.constants.TaskConstants
import com.devmasterteam.tasks.service.listener.APIListener
import com.google.gson.Gson
import retrofit2.Response

open class BaseRepository {

    fun <T> handleResponse(response: Response<T>, listener: APIListener<T>) {
        if (response.code() == TaskConstants.HTTP.SUCCESS) {
            response.body()?.let {
                listener.onSuccess(it)
            }
        } else {
            listener.onFailure(failReponseFromJson(response.errorBody()!!.string()))
        }
    }

    private fun failReponseFromJson(jsonString: String): String {
        return Gson().fromJson(jsonString, String::class.java)
    }

}