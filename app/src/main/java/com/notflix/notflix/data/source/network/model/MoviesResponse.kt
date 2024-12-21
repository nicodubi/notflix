package com.notflix.notflix.data.source.network.model

import com.notflix.notflix.data.model.Movie

/**
 * Created by Nicolas Dubiansky on 14/12/2024.
 */

data class MoviesResponse(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)
