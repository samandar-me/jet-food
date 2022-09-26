package com.sdk.jetfood.data.dto

import com.squareup.moshi.Json

enum class SubItemViewType {
    @Json(name = "bannerElement") Banner,
    @Json(name = "categoryElement") Category,
    @Json(name = "restaurantElement") Restaurant
}