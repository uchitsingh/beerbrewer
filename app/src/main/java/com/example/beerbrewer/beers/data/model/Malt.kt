package com.example.beerbrewer.beers.data.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Malt(
    @Json(name = "amount")
    val amount: AmountX?,
    @Json(name = "name")
    val name: String?
) : Parcelable