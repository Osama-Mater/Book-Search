package com.osama.books.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.osama.books.domain.usecase.BookSearch
import com.osama.books.ui.vm.base.BaseViewModel
import com.osama.books.ui.vm.mapper.BookSearchDomainToUiModelMapper
import com.osama.books.ui.vm.model.BookSearchUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class BookSearchViewModel @Inject constructor(
    private val bookSearch: BookSearch,
    private val bookSearchDomainToUiModelMapper: BookSearchDomainToUiModelMapper
) :
    BaseViewModel() {
    private val searchResultRetrieved: MutableLiveData<List<BookSearchUiModel>> = MutableLiveData()
    private val sortAlphaOrAuthor: MutableLiveData<List<BookSearchUiModel>> = MutableLiveData()

    fun onSearchResultRetrieved(): LiveData<List<BookSearchUiModel>> = searchResultRetrieved
    fun onSortResultRetrieved(): LiveData<List<BookSearchUiModel>> = sortAlphaOrAuthor

    fun bookSearch(searchValue: String) {
        bookSearch.execute(searchValue)
            .compose(schedulerProvider.doOnIoObserveOnMainObservable())
            .map(bookSearchDomainToUiModelMapper::toUiModel)
            .subscribe({
                searchResultRetrieved.postValue(it)
            }, { throwable ->
                Timber.d(throwable)
            })
            .also { subscriptions.add(it) }
    }

    fun sortByAuthor() {
        sortAlphaOrAuthor.value = onSearchResultRetrieved().value?.sortedBy {
            it.authorName
        }
    }

    fun sortByAlphabetically() {
        sortAlphaOrAuthor.value = onSearchResultRetrieved().value?.sortedBy {
            it.bookName
        }
    }
}