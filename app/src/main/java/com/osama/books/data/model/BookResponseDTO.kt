package com.osama.books.data.model

import com.google.gson.annotations.SerializedName

data class BookResponseDTO(
    @SerializedName("totalItems")
    val mTotalItems: Int,

    @SerializedName("items")
    val mBookResults: List<BookDTO>
)
