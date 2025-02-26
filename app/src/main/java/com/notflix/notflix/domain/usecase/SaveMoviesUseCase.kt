package com.notflix.notflix.domain.usecase

import com.notflix.notflix.data.model.Movie
import com.notflix.notflix.data.repository.MoviesRepository
import javax.inject.Inject

/**
 * Created by Nicolas Dubiansky on 21/02/2025.
 */
class SaveMoviesUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {
    suspend fun saveMovies(movies: List<Movie>) {
        moviesRepository.saveMovies(movies)
    }
}