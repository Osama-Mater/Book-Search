package com.osama.books.data.repository

import com.osama.books.data.model.BookResponseDTO
import com.osama.books.data.source.remote.BooksRemoteDataSource
import com.osama.books.domain.BooksRepository
import io.reactivex.Observable
import javax.inject.Inject

class BooksRepositoryImpl @Inject constructor(private val booksRemoteDataSource: BooksRemoteDataSource) :
    BooksRepository {
    override fun getBooks(searchValue: String): Observable<BookResponseDTO> =
        booksRemoteDataSource.getBooks(searchValue)
}