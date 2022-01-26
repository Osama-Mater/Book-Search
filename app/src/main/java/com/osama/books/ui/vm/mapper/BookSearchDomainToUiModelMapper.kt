package com.osama.books.ui.vm.mapper

import com.osama.books.data.model.BookResponseDTO
import com.osama.books.ui.vm.model.BookSearchUiModel

interface BookSearchDomainToUiModelMapper {
    fun toUiModel(
        bookSearchDomainModel: BookResponseDTO
    ): List<BookSearchUiModel>
}

class BookSearchDomainToUiModelMapperImpl : BookSearchDomainToUiModelMapper {
    override fun toUiModel(bookSearchDomainModel: BookResponseDTO): List<BookSearchUiModel> =
        bookSearchDomainModel.mBookResults.map { bookDTO ->
            BookSearchUiModel(
                bookName = bookDTO.mVolumeInfo.mTitle,
                authorName = bookDTO.mVolumeInfo.mAuthors[0],
                imageUrl = bookDTO.mVolumeInfo.mImageLinks?.mThumbnail
            )
        }

}