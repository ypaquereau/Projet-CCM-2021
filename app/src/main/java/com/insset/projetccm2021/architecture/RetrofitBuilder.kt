package com.insset.projetccm2021.architecture

import com.google.gson.GsonBuilder
import com.insset.projetccm2021.list.remote.MovieShowQuoteEndpoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private val movieShowQuoteRetrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://movie-quote-api.herokuapp.com/v1/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()))
        .build()

    fun getMovieShowQuote(): MovieShowQuoteEndpoint = movieShowQuoteRetrofit.create(MovieShowQuoteEndpoint::class.java)
}