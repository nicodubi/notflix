package com.notflix.notflix.data.source.network

import com.notflix.notflix.data.model.Movie

/**
 * Created by Nicolas Dubiansky on 03/12/2024.
 */
interface MoviesRemoteDataSource {
    suspend fun getMoviesNetwork(): List<Movie>
}