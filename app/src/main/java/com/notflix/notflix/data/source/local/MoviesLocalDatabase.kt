package com.notflix.notflix.data.source.local

import com.notflix.notflix.data.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/**
 * Created by Nicolas Dubiansky on 03/12/2024.
 */
class MoviesLocalDatabase : MoviesLocalDataSource {
    override suspend fun getMoviesLocal(): List<Movie> = withContext(Dispatchers.IO) {
        delay(2000L)
        List(40) { Movie(title = "Movie $it", year = 2000 + it) }
    }

}