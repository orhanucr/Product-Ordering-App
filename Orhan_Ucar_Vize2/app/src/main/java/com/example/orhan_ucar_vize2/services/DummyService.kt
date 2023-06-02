package com.example.orhan_ucar_vize2.services

import retrofit2.Call
import retrofit2.http.GET

interface DummyService {
    @GET("products")
    fun getProducts(): Call<ProductResponse>
}
