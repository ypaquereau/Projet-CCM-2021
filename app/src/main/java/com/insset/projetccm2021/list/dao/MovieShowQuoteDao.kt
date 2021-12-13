package com.insset.projetccm2021.list.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.insset.projetccm2021.list.model.MovieShowQuoteRoom

@Dao
interface MovieShowQuoteDao {
    @Query("SELECT * FROM movie_show_quote")
    fun selectAll(): LiveData<List<MovieShowQuoteRoom>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movieShowQuoteRoom: MovieShowQuoteRoom)

    @Query("DELETE FROM movie_show_quote")
    fun deleteAll()
}