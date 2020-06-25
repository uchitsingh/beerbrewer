package com.example.beerbrewer.beers.data.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Hop(
    @Json(name = "add")
    val add: String?,
    @Json(name = "amount")
    val amount: Amount?,
    @Json(name = "attribute")
    val attribute: String?,
    @Json(name = "name")
    val name: String?
) : Parcelable