package com.sdk.jetfood.data.remote

import com.sdk.jetfood.data.dto.FoodDto
import retrofit2.Response
import retrofit2.http.GET

interface JetService {
    @GET("data.json")
    suspend fun getAllFoods(): Response<FoodDto>
}