package com.example.lenovo.desafioandroid.api

import com.example.lenovo.desafioandroid.model.ItemResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("/search/repositories?q=language:kotlin&sort=stars&page=1")
    fun getrepos(
    ): Call<ItemResponse>
}

