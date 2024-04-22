package com.example.entregafinal

import retrofit2.http.GET

interface carServic {
    @GET("coches")
    suspend fun getCars(): List<Car>
}