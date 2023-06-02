package com.example.orhan_ucar_vize2.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClientSingleton {
    private const val BASE_URL = "https://dummyjson.com/"
    private var retrofit: Retrofit? = null

    fun getInstance(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}
