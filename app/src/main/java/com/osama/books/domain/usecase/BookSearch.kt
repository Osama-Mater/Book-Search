package com.osama.books.domain.usecase

import com.osama.books.data.model.BookResponseDTO
import com.osama.books.domain.BooksRepository
import io.reactivex.Observable
import javax.inject.Inject

interface BookSearch {
    fun execute(searchValue: String): Observable<BookResponseDTO>
}

class BookSearchImpl @Inject constructor(private val booksRepository: BooksRepository) :
    BookSearch {
    override fun execute(searchValue: String): Observable<BookResponseDTO> =
        booksRepository.getBooks(searchValue)
}