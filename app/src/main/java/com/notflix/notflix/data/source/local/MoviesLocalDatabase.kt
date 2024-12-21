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
        List(40) {
            Movie(
                title = "Movie $it",
                id = it,
                overview = "Movie Description $it",
                vote_average = 7.2,
                release_date = "07/04/20$it"
            )
        }
    }

}