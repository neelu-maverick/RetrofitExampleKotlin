package com.example.retrofitexamplekotlin.retrofit


import com.example.retrofitexamplekotlin.BuildConfig
import com.example.retrofitexamplekotlin.data.Api
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun getHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .also {
                if (BuildConfig.DEBUG) {
                    val logging = HttpLoggingInterceptor()
                    logging.level = (HttpLoggingInterceptor.Level.BODY)
                    it.addInterceptor(logging)
                }
            }.build()
    }

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("https://simplifiedcoding.net/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit.Builder): Api {
        return retrofit
            .build()
            .create(Api::class.java)
    }
}