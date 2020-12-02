package com.example.marvel.api

import getTimeStamp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val MY_PUPLIC_KEY = "2e2f85a0c6c0a09ca52f8d43a60ce693"
const val MY_PRIVATE_KEY = "81e78d0a4c7082531b0e5a0364f16a8712c1f26c"

class NetworkUtils {
    companion object {
        private const val BASE_URL = "https://gateway.marvel.com"

        fun getRetrofitInstance(baseUrl: String = BASE_URL): Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}