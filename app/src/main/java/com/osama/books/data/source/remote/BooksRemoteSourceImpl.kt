package com.osama.books.data.source.remote

import com.osama.books.data.api.BooksApiService
import com.osama.books.data.model.BookResponseDTO
import io.reactivex.Observable
import javax.inject.Inject

class BooksRemoteSourceImpl @Inject constructor(private val apiService: BooksApiService) :
    BooksRemoteDataSource {
    override fun getBooks(searchValue: String): Observable<BookResponseDTO> {
        return apiService.getBooks(query = searchValue)
    }
}