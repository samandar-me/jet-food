package com.sdk.jetfood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sdk.jetfood.presentation.HomeScreen
import com.sdk.jetfood.presentation.HomeViewModel
import com.sdk.jetfood.ui.theme.JetFoodTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetFoodTheme {
                val viewModel = getViewModel<HomeViewModel>()
                HomeScreen(viewModel)
            }
        }
    }
}

