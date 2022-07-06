package com.example.tasks.service.repository

import android.content.Context
import android.widget.Toast
import com.example.tasks.service.HeaderModel
import com.example.tasks.service.repository.remote.PersonService
import com.example.tasks.service.repository.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonRepository(var context: Context) {

    private val mRemote = RetrofitClient.createService(PersonService::class.java)

    fun login(email: String, password: String) {
        val call: Call<HeaderModel> = mRemote.login(email, password)

        // Chamada Sincrona - Deixamos o usuário esperando até que a API retorne. Experiencia do usuário pode não ser
        // boa caso a API demore para retornar ou trave.

        // Chamada Assíncrona - deixamos o processamento da API em 2º plano, permitindo que o usuário continue o fluxo
        // do App - Essa forma é mais dificil, porém a mais indicada e a mais vista no mercado atual.
        call.enqueue(object : Callback<HeaderModel> {
            override fun onResponse(call: Call<HeaderModel>, response: Response<HeaderModel>) {
                if(response.isSuccessful){
                    // Response OK
                    val header = response.body() //response contém o body do retorno
                } else {
                    // Reponse Error
                    //Toast.makeText(context, "" + response.message(), Toast.LENGTH_LONG).show()
                }

            }
            override fun onFailure(call: Call<HeaderModel>, t: Throwable) {

            }
        })

    }

}