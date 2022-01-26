package com.osama.books.data.source.remote

import com.osama.books.data.model.BookResponseDTO
import io.reactivex.Observable

interface BooksRemoteDataSource {
    fun getBooks(searchValue: String): Observable<BookResponseDTO>
}