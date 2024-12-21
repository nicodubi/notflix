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
    private val BASE_IMAGE_TMDB_URL = "https://image.tmdb.org/t/p/w500/"

    override suspend fun getMoviesNetwork(): List<Movie> {
        val randomMoviesNames = listOf("Harry", "Spider", "Ring", "Batman", "IronMan")
        val moviesResponse = moviesNetworkServices.getMovies(randomMoviesNames.random())
        val movies = buildURLPosterImages(moviesResponse.results)
        return movies
    }

    private fun buildURLPosterImages(movies: List<Movie>) =
        movies.map { movie ->
            val posterPath = movie.poster_path?.let { BASE_IMAGE_TMDB_URL + it }
            movie.copy(poster_path = posterPath)
        }

}