package com.notflix.notflix.domain.usecase

import com.notflix.notflix.data.model.Movie
import com.notflix.notflix.data.repository.MoviesRepository
import javax.inject.Inject

/**
 * Created by Nicolas Dubiansky on 21/02/2025.
 */
class GetMovieDetailUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository
) {
    suspend fun getMovieDetail(id: Int): Movie {
        return moviesRepository.getMovie(id)

    }
}