package com.sdk.jetfood.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.request.ImageRequest
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun ImageLoader(
    modifier: Modifier = Modifier,
    image: String,
    color: Color? = null
) {
    val painter = rememberCoilPainter(request = image)
    Image(
        modifier = modifier,
        painter = painter,
        contentDescription = "",
        colorFilter = ColorFilter.tint(color ?: Color.LightGray)
    )
}