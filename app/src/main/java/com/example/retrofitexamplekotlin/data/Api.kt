package com.example.retrofitexamplekotlin.data

import com.example.retrofitexamplekotlin.Modal.ModelList
import retrofit2.http.GET

interface Api {
    @GET("demos/marvel/")
    suspend fun getModel(): ModelList
}