package com.osama.books.data.api

import com.osama.books.data.model.BookResponseDTO
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksApiService {
    @GET("volumes/")
    fun getBooks(
        @Query("q") query: String
    ): Observable<BookResponseDTO>

}