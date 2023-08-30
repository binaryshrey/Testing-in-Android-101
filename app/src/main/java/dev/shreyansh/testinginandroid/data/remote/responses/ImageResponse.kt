package com.androiddevs.shoppinglisttestingyt.data.remote.responses

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize


@JsonClass(generateAdapter = true)
@Parcelize
data class ImageResponse(
    val hits: List<ImageResult>,
    val total: Int,
    val totalHits: Int
) : Parcelable