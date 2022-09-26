package com.sdk.jetfood.util

sealed class Result<out T> {
    object Loading : Result<Nothing>()
    class Success<T>(val data: T?) : Result<T>()
    class Failure(val error: Throwable) : Result<Nothing>()
}