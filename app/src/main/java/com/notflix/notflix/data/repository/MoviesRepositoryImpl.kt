package com.notflix.notflix.data.repository

import com.notflix.notflix.data.model.Movie
import com.notflix.notflix.data.source.local.MoviesLocalDataSource
import com.notflix.notflix.data.source.network.MoviesRemoteDataSource
import javax.inject.Inject

/**
 * Created by Nicolas Dubiansky on 03/12/2024.
 */
class MoviesRepositoryImpl @Inject constructor(
    private val moviesRemoteDataSource: MoviesRemoteDataSource,
    private val moviesLocalDataSource: MoviesLocalDataSource
) : MoviesRepository {
    override suspend fun getMovies(): List<Movie> {
       val hasInternet = false
        return if (hasInternet) {
            moviesRemoteDataSource.getMoviesNetwork()
        } else {
            moviesLocalDataSource.getMoviesLocal()
        }
    }
}