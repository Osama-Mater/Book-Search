package com.osama.books.data.model

import com.google.gson.annotations.SerializedName

data class BookSaleInfoDTO(
    @SerializedName("buyLink")
    val mBuyLink: String
)
