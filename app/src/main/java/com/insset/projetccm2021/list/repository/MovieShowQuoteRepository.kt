package com.insset.projetccm2021.list.repository

import androidx.lifecycle.LiveData
import com.insset.projetccm2021.architecture.CustomApplication
import com.insset.projetccm2021.architecture.RetrofitBuilder
import com.insset.projetccm2021.list.model.MovieShowQuoteRetrofit
import com.insset.projetccm2021.list.model.MovieShowQuoteRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieShowQuoteRepository {
    private val mMovieShowQuoteDao = CustomApplication.instance.mApplicationDatabase.movieShowQuoteDao()

    fun selectAllMovieShowQuote(): LiveData<List<MovieShowQuoteRoom>> {
        return mMovieShowQuoteDao.selectAll()
    }

    private suspend fun insertMovieShowQuote(movieShowQuote: MovieShowQuoteRoom) = withContext(Dispatchers.IO) {
        mMovieShowQuoteDao.insert(movieShowQuote)
    }

    suspend fun deleteAllMovieShowQuote() = withContext(Dispatchers.IO) {
        mMovieShowQuoteDao.deleteAll()
    }

    suspend fun fetchData() {
        insertMovieShowQuote(RetrofitBuilder.getMovieShowQuote().getRandomQuote().toRoom())
    }
}

private fun MovieShowQuoteRetrofit.toRoom(): MovieShowQuoteRoom {
    return MovieShowQuoteRoom(
        quote = quote,
        character = character,
        source = source
    )
}