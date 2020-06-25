package com.example.beerbrewer.beers.data.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class AmountX(
    @Json(name = "unit")
    val unit: String?,
    @Json(name = "value")
    val value: Double?
) : Parcelable