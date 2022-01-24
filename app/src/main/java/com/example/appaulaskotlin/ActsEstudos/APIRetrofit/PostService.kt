package com.example.appaulaskotlin.ActsEstudos.APIRetrofit

import retrofit2.Call
import retrofit2.http.GET

interface PostService {

    @GET("posts")
    fun list() : Call<List<PostModel>>

}