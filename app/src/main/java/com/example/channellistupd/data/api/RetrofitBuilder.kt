package com.example.channellistupd.data.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

@ExperimentalSerializationApi
object RetrofitBuilder {
    private const val BASE_URL = "https://limehdads.online/"

    private val json = Json { ignoreUnknownKeys = true }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory(MediaType.get("application/json")))
            .build()

    }

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)
}