package com.sdk.jetfood.domain.repository

import com.sdk.jetfood.domain.model.Food
import com.sdk.jetfood.util.Result
import kotlinx.coroutines.flow.Flow

interface JetRepository {
    suspend fun getAllFoods(): Flow<Result<List<Food>>>
}