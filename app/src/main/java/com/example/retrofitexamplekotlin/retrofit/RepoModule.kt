package com.example.retrofitexamplekotlin.retrofit

import com.example.retrofitexamplekotlin.data.Api
import com.example.retrofitexamplekotlin.data.RepoImplimentation
import com.example.retrofitexamplekotlin.data.RepoInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepoModule {

    @Singleton
    @Provides
    fun providesRepo(apiInterface: Api): RepoInterface {
        return RepoImplimentation(apiInterface)
    }
}