package com.notflix.notflix.data.source.local

import com.notflix.notflix.data.model.Movie
import javax.inject.Inject

/**
 * Created by Nicolas Dubiansky on 03/12/2024.
 */

interface MoviesLocalDataSource {
    suspend fun getMoviesLocal(): List<Movie>

}