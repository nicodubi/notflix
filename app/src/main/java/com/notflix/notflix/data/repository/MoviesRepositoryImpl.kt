package com.notflix.notflix.data.repository

import com.notflix.notflix.data.model.Movie
import com.notflix.notflix.data.source.local.MoviesLocalDataSource
import com.notflix.notflix.data.source.network.MoviesRemoteDataSource

/**
 * Created by Nicolas Dubiansky on 03/12/2024.
 */
class MoviesRepositoryImpl(
    private val moviesRemoteDataSource: MoviesRemoteDataSource,
    private val moviesLocalDataSource: MoviesLocalDataSource
) : MoviesRepository {
    override suspend fun getMovies(): List<Movie> {
       val hasInternet = true
        return if (hasInternet) {
            moviesRemoteDataSource.getMoviesNetwork()
        } else {
            moviesLocalDataSource.getMoviesLocal()
        }
    }
}