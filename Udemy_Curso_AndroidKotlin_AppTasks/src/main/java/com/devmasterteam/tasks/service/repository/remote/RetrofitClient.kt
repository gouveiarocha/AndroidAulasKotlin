package com.devmasterteam.tasks.service.repository.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor() {

    // Singleton.
    companion object {
        private lateinit var INSTANCE: Retrofit
        private fun getRetrofitInstance(): Retrofit {
            if (!::INSTANCE.isInitialized) {
                synchronized(RetrofitClient::class) { //evitar problemas com multi-threads.
                    INSTANCE = Retrofit.Builder()
                        .baseUrl("http://devmasterteam.com/CursoAndroidAPI/") //url base API.
                        .client(OkHttpClient.Builder().build()) //cliente http.
                        .addConverterFactory(GsonConverterFactory.create()) //conversor json.
                        .build()
                }
            }
            return INSTANCE
        }

        // Get com implementação de classe genérica, assim podemos criar serviço com qualquer classe.
        fun <S> getService(serviceClass: Class<S>): S{
            return getRetrofitInstance().create(serviceClass)
        }

    }

}