package com.example.beerbrewer.beers.data.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
@JsonClass(generateAdapter = true)
data class Ingredients(
    @Json(name = "hops")
    val hops: @RawValue List<Hop>?,
    @Json(name = "malt")
    val malt:@RawValue List<Malt>?,
    @Json(name = "yeast")
    val yeast: String?
) : Parcelable