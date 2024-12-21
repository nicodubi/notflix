package com.notflix.notflix.data.model

/**
 * Created by Nicolas Dubiansky on 27/11/2024.
 */
data class Movie(
    val id: Int,
    val overview: String,
    val poster_path: String? = null,
    val release_date: String,
    val title: String,
    val vote_average: Double,
)