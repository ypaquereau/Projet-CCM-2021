package com.insset.projetccm2021.list.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.insset.projetccm2021.databinding.ItemHeaderBinding
import com.insset.projetccm2021.databinding.ItemMovieShowQuoteBinding
import com.insset.projetccm2021.list.model.Header
import com.insset.projetccm2021.list.model.MovieShowQuoteUi
import com.insset.projetccm2021.list.model.MyObjectForRecyclerView
import java.lang.RuntimeException

val diffUtils = object : DiffUtil.ItemCallback<MyObjectForRecyclerView>() {
    override fun areItemsTheSame(oldItem: MyObjectForRecyclerView, newItem: MyObjectForRecyclerView): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MyObjectForRecyclerView, newItem: MyObjectForRecyclerView): Boolean {
        return oldItem == newItem
    }
}

class ApiListAdapter : ListAdapter<MyObjectForRecyclerView, RecyclerView.ViewHolder>(diffUtils) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when (viewType) {
            ItemType.MOVIESHOWQUOTE.type -> {
                MovieShowQuoteViewHolder(
                    ItemMovieShowQuoteBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            ItemType.HEADER.type -> {
                HeaderViewHolder(
                    ItemHeaderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else -> throw RuntimeException("$viewType type not exist")
        }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is MovieShowQuoteUi -> ItemType.MOVIESHOWQUOTE.type
            is Header -> ItemType.HEADER.type
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        when (holder.itemViewType) {
            ItemType.MOVIESHOWQUOTE.type -> (holder as MovieShowQuoteViewHolder).bind(getItem(position) as MovieShowQuoteUi)
            ItemType.HEADER.type -> (holder as HeaderViewHolder).bind(getItem(position) as Header)

            else -> throw RuntimeException("${holder.itemViewType} type not exist")
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

class HeaderViewHolder(
    private val binding: ItemHeaderBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(objectDataHeaderSample: Header) {
        binding.itemRecyclerViewHeader.text = objectDataHeaderSample.header
    }
}

enum class ItemType(val type: Int) {
    HEADER(0),
    MOVIESHOWQUOTE(1)
}