package com.osama.books.domain.di

import com.osama.books.domain.BooksRepository
import com.osama.books.domain.usecase.BookSearch
import com.osama.books.domain.usecase.BookSearchImpl
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    @Reusable
    fun provideBookSearch(booksRepository: BooksRepository): BookSearch =
        BookSearchImpl(booksRepository)
}