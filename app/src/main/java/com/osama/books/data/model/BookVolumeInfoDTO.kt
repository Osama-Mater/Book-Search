package com.osama.books.data.model

import com.google.gson.annotations.SerializedName

data class BookVolumeInfoDTO(
    @SerializedName("title")
    val mTitle: String,

    @SerializedName("subtitle")
    val mSubtitle: String,

    @SerializedName("authors")
    val mAuthors: Array<String>,

    @SerializedName("description")
    val mDescription: String,

    @SerializedName("imageLinks")
    val mImageLinks: BookImageLinksDTO? = null
)