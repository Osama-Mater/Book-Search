package com.osama.books.ui.vm.model

data class BookSearchUiModel(
    val bookName: String,
    val authorName: String,
    val imageUrl: String? = null
)
