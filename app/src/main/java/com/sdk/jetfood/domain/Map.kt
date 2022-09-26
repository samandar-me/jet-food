package com.sdk.jetfood.domain

import com.sdk.jetfood.data.dto.DataX
import com.sdk.jetfood.domain.model.Food

fun DataX.toFood(): Food {
    return Food(
        title = title,
        image = imageUrl,
        bgColor = meta.bgColor,
        viewType = viewType
    )
}