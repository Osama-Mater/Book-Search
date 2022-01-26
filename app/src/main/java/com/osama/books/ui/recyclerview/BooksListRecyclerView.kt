package com.osama.books.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.osama.books.R
import com.osama.books.databinding.BookListItemBinding
import com.osama.books.ui.vm.model.BookSearchUiModel

class BooksListRecyclerView : RecyclerView.Adapter<BooksListRecyclerView.BookViewHolder>() {

    var booksList: List<BookSearchUiModel> = emptyList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookViewHolder {
        return BookViewHolder(
            BookListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(booksList[position])
    }

    override fun getItemCount(): Int = booksList.size

    class BookViewHolder(private val binding: BookListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(bookSearchUiModel: BookSearchUiModel) {
            Glide
                .with(binding.root.context)
                .load(bookSearchUiModel.imageUrl)
                .centerCrop()
                .error(R.drawable.ic_warning)
                .into(binding.bookCoverIV)

            binding.bookNameTV.text = bookSearchUiModel.bookName
        }
    }

}