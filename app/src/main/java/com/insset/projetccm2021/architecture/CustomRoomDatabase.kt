package com.insset.projetccm2021.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.insset.projetccm2021.list.dao.MovieShowQuoteDao
import com.insset.projetccm2021.list.model.MovieShowQuoteRoom

@Database(
    entities = [
        MovieShowQuoteRoom::class
    ],
    version = 1,
    exportSchema = false
)

abstract class CustomRoomDatabase: RoomDatabase() {
    abstract fun movieShowQuoteDao(): MovieShowQuoteDao
}