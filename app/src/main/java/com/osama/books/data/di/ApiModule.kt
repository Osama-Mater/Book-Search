package com.osama.books.data.di

import com.osama.books.data.api.BooksApiService
import com.osama.books.data.source.remote.BooksRemoteDataSource
import com.osama.books.data.source.remote.BooksRemoteSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    fun provideBooksRemoteSource(
        apiService: BooksApiService
    ): BooksRemoteDataSource =
        BooksRemoteSourceImpl(apiService)

    @Provides
    @JvmStatic
    internal fun provideApi(retrofit: Retrofit): BooksApiService =
        retrofit.create(BooksApiService::class.java)

    @Provides
    @JvmStatic
    internal fun provideRetrofit(
        httpBuilder: OkHttpClient.Builder,
        retrofitBuilder: Retrofit.Builder
    ): Retrofit = retrofitBuilder
        .client(httpBuilder.build())
        .build()
}