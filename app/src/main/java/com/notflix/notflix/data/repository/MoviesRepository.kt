package com.notflix.notflix.data.repository

import com.notflix.notflix.data.model.Movie

/**
 * Created by Nicolas Dubiansky on 03/12/2024.
 */
interface MoviesRepository {

    suspend fun getMovies() : List<Movie>
}