package com.notflix.notflix.domain.usecase

import com.notflix.notflix.data.Movie

/**
 * Created by Nicolas Dubiansky on 28/11/2024.
 */
class GetMoviesUseCase {

    fun getFakeMovies(): List<Movie> {

        return List(30) { it -> Movie(title = "Movie: $it", year = 2000 + it) }
    }
}