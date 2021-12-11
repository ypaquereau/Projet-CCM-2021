package com.insset.projetccm2021.list.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/** Object use for UI */
data class MovieShowQuoteUi(
    val quote: String,
    val character: String,
    val source: String
)

/** Object use for room */
@Entity(tableName = "movie_show_quote")
data class MovieShowQuoteRoom(
    @ColumnInfo(name = "quote_text")
    val quote: String,

    @ColumnInfo(name = "quote_character")
    val character: String,

    @ColumnInfo(name = "quote_source")
    val source: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

/** Object use for retrofit */
data class MovieShowQuoteRetrofit(
    @Expose
    @SerializedName("quote")
    val quote: String,

    @Expose
    @SerializedName("role")
    val character: String,

    @Expose
    @SerializedName("show")
    val source: String,
)