package com.sdk.jetfood.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sdk.jetfood.R
import com.sdk.jetfood.presentation.component.ShowError
import com.sdk.jetfood.presentation.component.ShowLoading
import com.sdk.jetfood.util.Result
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel
) {
    val result by viewModel.result.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                },
                backgroundColor = Color.White,
                elevation = 5.dp
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when(val res = result) {
                is Result.Loading -> {
                    ShowLoading()
                }
                is Result.Failure -> {
                    ShowError(message = res.error.message ?: "Error occurred!") {
                        viewModel.getAllFoodList()
                    }
                }
                is Result.Success -> {
                    DashBoard(res.data ?: emptyList())
                }
            }
        }
    }
}