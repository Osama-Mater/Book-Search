package com.osama.books.data.di

import com.osama.books.data.repository.BooksRepositoryImpl
import com.osama.books.data.source.remote.BooksRemoteDataSource
import com.osama.books.domain.BooksRepository
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class BooksRepositoryModule {
    @Provides
    @Reusable
    fun provideBooksRepository(
        booksRemoteSource: BooksRemoteDataSource
    ): BooksRepository = BooksRepositoryImpl(booksRemoteSource)

}