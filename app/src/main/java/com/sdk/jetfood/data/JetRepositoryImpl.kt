package com.sdk.jetfood.data

import android.util.Log
import com.sdk.jetfood.data.remote.JetService
import com.sdk.jetfood.domain.model.Food
import com.sdk.jetfood.domain.repository.JetRepository
import com.sdk.jetfood.domain.toFood
import com.sdk.jetfood.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber

class JetRepositoryImpl(
    private val jetService: JetService
) : JetRepository {
    override suspend fun getAllFoods(): Flow<Result<List<Food>>> {
        return flow {
            try {
                emit(Result.Loading)
                val response = jetService.getAllFoods()
                if (response.isSuccessful) {
                    val body = response.body()!!
                    val foodList = mutableListOf<Food>()
                    body.categories.forEach {
                        foodList.add(it.toFood())
                    }
                    emit(Result.Success(foodList))
                    Timber.tag("@@@@").d("getAllFoods: %s", response.isSuccessful)
                }
            } catch (e: Exception) {
                emit(Result.Failure(e))
            }
        }
    }
}