package com.osama.books.data.model

import com.google.gson.annotations.SerializedName

data class BookDTO(
    @SerializedName("id")
    val mId: String,

    @SerializedName("volumeInfo")
    val mVolumeInfo: BookVolumeInfoDTO,

    @SerializedName("saleInfo")
    val mSaleInfo: BookSaleInfoDTO

)