package com.example.beerbrewer.beers.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Amount(
    @Json(name = "unit")
    val unit: String?,
    @Json(name = "value")
    val value: Double?
)