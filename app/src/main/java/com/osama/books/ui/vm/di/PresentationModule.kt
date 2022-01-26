package com.osama.books.ui.vm.di

import com.osama.books.ui.vm.mapper.BookSearchDomainToUiModelMapper
import com.osama.books.ui.vm.mapper.BookSearchDomainToUiModelMapperImpl
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PresentationModule {
    @Provides
    @Reusable
    fun provideBookSearchDomainToUiModelMapper(): BookSearchDomainToUiModelMapper {
        return BookSearchDomainToUiModelMapperImpl()
    }
}