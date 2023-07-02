package com.example.retrofitexamplekotlin.data

import com.example.retrofitexamplekotlin.Modal.ModelList

interface RepoInterface {
    suspend fun getModel():
            ModelList
}