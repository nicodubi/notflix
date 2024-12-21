package com.notflix.notflix.domain.usecase

import com.notflix.notflix.data.repository.MoviesRepository
import javax.inject.Inject

/**
 * Created by Nicolas Dubiansky on 28/11/2024.
 */
class GetMoviesUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {

    suspend fun getMovies() = moviesRepository.getMovies()
}