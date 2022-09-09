package com.example.gouveiarocha.estudoskotlin.studies.API_Retrofit

import com.google.gson.annotations.SerializedName

class PostModel {

    @SerializedName("id") //O SerializedName converte o nome da key da api na minha variavel, caso os nomes sejam diferentes.
    val id: Int = 0

    val userId: Int = 0
    val title: String = ""
    val body: String = ""

}