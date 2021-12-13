package com.insset.projetccm2021.list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.insset.projetccm2021.list.model.MovieShowQuoteRoom
import com.insset.projetccm2021.list.model.MovieShowQuoteUi
import com.insset.projetccm2021.list.repository.MovieShowQuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieShowViewModel : ViewModel() {
    private val movieShowQuoteRepository: MovieShowQuoteRepository by lazy { MovieShowQuoteRepository() }
    var movieShowQuoteLiveData: LiveData<List<MovieShowQuoteUi>> = movieShowQuoteRepository.selectAllMovieShowQuote().map {
        it.toUi()
    }

    fun fetchNewQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            movieShowQuoteRepository.fetchData()
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            movieShowQuoteRepository.deleteAllMovieShowQuote()
        }
    }
}

private fun List<MovieShowQuoteRoom>.toUi(): List<MovieShowQuoteUi> {
    return asSequence().map {
        MovieShowQuoteUi(
            quote = it.quote,
            character = it.character,
            source = it.source,
        )
    }.toList()
}