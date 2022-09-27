package com.sdk.jetfood.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sdk.jetfood.domain.model.Food
import com.sdk.jetfood.domain.repository.JetRepository
import com.sdk.jetfood.util.Result
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: JetRepository
) : ViewModel() {
    private val _result: MutableStateFlow<Result<List<Food>>> = MutableStateFlow(Result.Loading)
    val result: StateFlow<Result<List<Food>>> get() = _result

    init {
        getAllFoodList()
    }

    fun getAllFoodList() {
        viewModelScope.launch {
            repository.getAllFoods().collectLatest {
                delay(1000)
                _result.value = it
            }
        }
    }
}