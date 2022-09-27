package com.sdk.jetfood.domain

import com.sdk.jetfood.data.dto.Category
import com.sdk.jetfood.domain.model.Food

fun Category.toFood(): Food {
    return Food(
        title = strCategory,
        image = strCategoryThumb,
        desc = strCategoryDescription
    )
}