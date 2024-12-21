package com.notflix.notflix.data.source.network

import com.notflix.notflix.data.model.Movie
import javax.inject.Inject

/**
 * Created by Nicolas Dubiansky on 03/12/2024.
 */
class MoviesRemoteDataSourceImpl @Inject constructor(
    private val moviesNetworkServices: MoviesNetworkServices
) :
    MoviesRemoteDataSource {
    override suspend fun getMoviesNetwork(): List<Movie> {
        val randomMoviesNames = listOf("Harry", "Spider", "Ring", "Batman", "IronMan")
        val moviesResponse = moviesNetworkServices.getMovies(randomMoviesNames.random())
        return moviesResponse.results
    }
}