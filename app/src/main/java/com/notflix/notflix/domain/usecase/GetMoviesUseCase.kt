package com.notflix.notflix.domain.usecase

import com.notflix.notflix.data.model.Movie
import com.notflix.notflix.data.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Nicolas Dubiansky on 28/11/2024.
 */
class GetMoviesUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {

    suspend fun getFakeMovies() = moviesRepository.getMovies()
}