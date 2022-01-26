package com.osama.books.domain

import com.osama.books.data.model.BookResponseDTO
import io.reactivex.Observable

interface BooksRepository {
    fun getBooks(searchValue: String): Observable<BookResponseDTO>
}