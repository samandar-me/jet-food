package com.sdk.jetfood.data.remote

import com.sdk.jetfood.data.dto.FoodDTO
import retrofit2.Response
import retrofit2.http.GET

interface JetService {
    @GET("api/json/v1/1/categories.php")
    suspend fun getAllFoods(): Response<FoodDTO>
}