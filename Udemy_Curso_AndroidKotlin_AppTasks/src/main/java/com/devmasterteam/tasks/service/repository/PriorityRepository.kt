package com.devmasterteam.tasks.service.repository

import android.content.Context
import com.devmasterteam.tasks.R
import com.devmasterteam.tasks.service.listener.APIListener
import com.devmasterteam.tasks.service.model.PriorityModel
import com.devmasterteam.tasks.service.repository.local.TaskDatabase
import com.devmasterteam.tasks.service.repository.remote.PriorityService
import com.devmasterteam.tasks.service.repository.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PriorityRepository(context: Context) : BaseRepository(context) {

    companion object {
        private val cache = mutableMapOf<Int, String>()
        private fun getDescriptionCache(id: Int): String {
            return cache[id] ?: ""
        }
        fun setDescriptionCache(id: Int, str: String){
            cache[id] = str
        }
    }

    fun getDescription(id: Int): String {
        val descriptionCache = getDescriptionCache(id)
        return descriptionCache.ifEmpty {
            val description = database.getDescription(id)
            setDescriptionCache(id, description)
            description
        }
    }

    private val remote = RetrofitClient.getService(PriorityService::class.java)
    private val database = TaskDatabase.getDatabase(context).priorityDAO()

    fun list(): List<PriorityModel> {
        return database.list()
    }

    fun list(listener: APIListener<List<PriorityModel>>) {
        executeCall(remote.list(), listener)
    }

    fun save(list: List<PriorityModel>) {
        database.clear()
        database.save(list)
    }

}