package com.example.retrofitexamplekotlin.data

import com.example.retrofitexamplekotlin.Modal.ModelList

class RepoImplimentation constructor(private val apiInterface: Api) : RepoInterface {
    override suspend fun getModel(): ModelList {
        return apiInterface.getModel()
    }

}