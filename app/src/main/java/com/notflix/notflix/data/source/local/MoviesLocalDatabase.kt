package com.notflix.notflix.data.source.local

import com.notflix.notflix.data.model.Movie
import com.notflix.notflix.data.model.getFakeMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/**
 * Created by Nicolas Dubiansky on 03/12/2024.
 */
class MoviesLocalDatabase : MoviesLocalDataSource {
    private var movies: List<Movie> = emptyList() //InMemoryCache (Fake Database)

    override suspend fun getMoviesLocal(): List<Movie> = withContext(Dispatchers.IO) {
        if (movies.isEmpty()) {
            movies = getFakeDatabaseMovies()
        }
        return@withContext movies
    }


    override suspend fun saveMovies(movies: List<Movie>) {
        withContext(Dispatchers.IO) {
            this@MoviesLocalDatabase.movies = movies
        }
    }

    override suspend fun getMovie(id: Int): Movie? = withContext(Dispatchers.IO) {
        movies.find { it.id == id }
    }


    private fun getFakeDatabaseMovies(): List<Movie> {
        return List(40) {
            getFakeMovie(it)
        }
    }
}