package com.osama.books.data.model

import com.google.gson.annotations.SerializedName

data class BookImageLinksDTO(
    @SerializedName("thumbnail")
    val mThumbnail: String? = null,

    @SerializedName("small")
    val mThumbnailSmall: String,

    @SerializedName("medium")
    val mThumbnailMedium: String,

    @SerializedName("large")
    val mThumbnailLarge: String
)