package com.notflix.notflix.domain.usecase

import com.notflix.notflix.data.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/**
 * Created by Nicolas Dubiansky on 28/11/2024.
 */
class GetMoviesUseCase {
    suspend fun getFakeMovies(): List<Movie> = withContext(Dispatchers.IO) {
        delay(2000L) //Simulate heavy network request
        List(30) { it -> Movie(title = "Movie: $it", year = 2000 + it) }
    }
}