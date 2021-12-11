package com.insset.projetccm2021.list.remote

import com.insset.projetccm2021.list.model.MovieShowQuoteRetrofit
import retrofit2.http.GET

interface MovieShowQuoteEndpoint {
    @GET("quote")
    suspend fun getRandomQuote(): MovieShowQuoteRetrofit
}