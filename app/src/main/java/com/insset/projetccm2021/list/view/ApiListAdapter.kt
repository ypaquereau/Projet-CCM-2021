package com.insset.projetccm2021.list.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.insset.projetccm2021.databinding.ItemMovieShowQuoteBinding
import com.insset.projetccm2021.list.model.MovieShowQuoteUi

val diffUtils = object : DiffUtil.ItemCallback<MovieShowQuoteUi>() {
    override fun areItemsTheSame(oldItem: MovieShowQuoteUi, newItem: MovieShowQuoteUi): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MovieShowQuoteUi, newItem: MovieShowQuoteUi): Boolean {
        return oldItem == newItem
    }
}

class ApiListAdapter : ListAdapter<MovieShowQuoteUi, MovieShowQuoteViewHolder>(diffUtils) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieShowQuoteViewHolder {
        return MovieShowQuoteViewHolder(
            ItemMovieShowQuoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieShowQuoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class MovieShowQuoteViewHolder(
    private val binding: ItemMovieShowQuoteBinding
) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var ui: MovieShowQuoteUi

    fun bind(movieShowQuoteUi: MovieShowQuoteUi) {
        ui = movieShowQuoteUi
        binding.itemMovieShowQuote.text = movieShowQuoteUi.quote
        binding.itemMovieShowCharacter.text = movieShowQuoteUi.character
        binding.itemMovieShowSource.text = movieShowQuoteUi.source
    }
}