package com.devmasterteam.tasks.service.repository.remote

import com.devmasterteam.tasks.service.constants.TaskConstants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor() {

    // Singleton.
    companion object {

        private lateinit var INSTANCE: Retrofit
        private var token: String = ""
        private var personKey: String = ""

        private fun getRetrofitInstance(): Retrofit {

            val httpClient = OkHttpClient.Builder()

            httpClient.addInterceptor { chain ->
                val request = chain.request() //pega a requisição e barra ela.
                    .newBuilder() //adiciono o que eu preciso.
                    .addHeader(TaskConstants.HEADER.TOKEN_KEY, token)
                    .addHeader(TaskConstants.HEADER.PERSON_KEY, personKey)
                    .build() //faço novamente o build.
                chain.proceed(request) //libero para seguir.
            }

            if (!::INSTANCE.isInitialized) {
                synchronized(RetrofitClient::class) { //evitar problemas com multi-threads.
                    INSTANCE = Retrofit.Builder()
                        .baseUrl("http://devmasterteam.com/CursoAndroidAPI/") //url base API.
                        .client(httpClient.build()) //cliente http.
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

        // Recebe os headers e adiciona nas variaveis.
        fun addHeaders(tokenValue: String, personKeyValue: String){
            token = tokenValue
            personKey = personKeyValue
        }

    }

}