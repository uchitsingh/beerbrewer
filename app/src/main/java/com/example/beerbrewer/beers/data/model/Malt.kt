package com.example.beerbrewer.beers.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Malt(
    @Json(name = "amount")
    val amount: AmountX?,
    @Json(name = "name")
    val name: String?
)