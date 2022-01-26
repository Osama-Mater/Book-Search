package com.osama.books.ui

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import com.osama.books.R
import com.osama.books.databinding.ActivityMainBinding
import com.osama.books.ui.recyclerview.BooksListRecyclerView
import com.osama.books.ui.vm.BookSearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val booksListRecyclerView: BooksListRecyclerView = BooksListRecyclerView()
    private val viewModel by viewModels<BookSearchViewModel>()

    //For the SearchView
    private lateinit var mSearchView: SearchView

    //For the SearchView's MenuItem
    private lateinit var mSearchMenuItem: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
    }

    override fun onResume() {
        super.onResume()
        binding.bookList.apply {
            setHasFixedSize(true)
            adapter = booksListRecyclerView
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        if (intent != null) {
            handleIntent(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        val searchManager: SearchManager =
            (getSystemService(Context.SEARCH_SERVICE) as SearchManager)

        mSearchMenuItem = menu!!.findItem(R.id.search_action_id)
        mSearchView = mSearchMenuItem.actionView as SearchView

        mSearchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.search_action_id -> return false
            R.id.sort_alpha -> {
                viewModel.sortByAlphabetically()
                viewModel.onSortResultRetrieved().observe(this, Observer {
                    booksListRecyclerView.booksList = it
                    booksListRecyclerView.notifyDataSetChanged()
                })
                return true
            }
            R.id.sort_author -> {
                viewModel.sortByAuthor()
                viewModel.onSortResultRetrieved().observe(this, Observer {
                    booksListRecyclerView.booksList = it
                    booksListRecyclerView.notifyDataSetChanged()
                })
                return true
            }
            else ->
                return super.onOptionsItemSelected(item)
        }
    }

    private fun handleIntent(intent: Intent) {
        if (Intent.ACTION_SEARCH == intent.action) {
            intent.getStringExtra(SearchManager.QUERY)?.also { query ->
                viewModel.bookSearch(query)
                viewModel.onSearchResultRetrieved().observe(this, Observer {
                    booksListRecyclerView.booksList = it
                    booksListRecyclerView.notifyDataSetChanged()
                })
            }
        }
    }
}