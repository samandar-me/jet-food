package com.sdk.jetfood.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastForEach
import com.sdk.jetfood.domain.model.Food
import com.sdk.jetfood.presentation.component.ImageLoader
import com.sdk.jetfood.util.Constants
import com.sdk.jetfood.util.Constants.HORIZONTAL
import com.sdk.jetfood.util.Constants.VERTICAL

@Composable
fun DashBoard(data: List<Food>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(12.dp)
    ) {
        items(data) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                shape = RoundedCornerShape(5.dp),
                elevation = 5.dp
            ) {
                ImageLoader(image = it.image, modifier = Modifier.fillMaxWidth())
                BannerText(title = it.title, modifier = Modifier.fillMaxWidth())
            }
        }
    }
}

@Composable
private fun BannerText(
    modifier: Modifier = Modifier,
    title: String
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Black.copy(alpha = 0.3f))
            .padding(10.dp),
        text = title,
        style = MaterialTheme.typography.subtitle2.copy(
            color = Color.White,
            fontSize = 15.sp
        )
    )
}