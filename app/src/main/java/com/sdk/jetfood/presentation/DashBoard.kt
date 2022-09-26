package com.sdk.jetfood.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sdk.jetfood.domain.model.Food
import com.sdk.jetfood.util.Constants.HORIZONTAL

@Composable
fun DashBoard(data: List<Food>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        itemsIndexed(items = data){ index, item ->
            when(item.viewType) {
                HORIZONTAL -> {

                }
            }
        }
    }
}