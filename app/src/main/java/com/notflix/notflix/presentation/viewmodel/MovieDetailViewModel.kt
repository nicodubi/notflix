package com.notflix.notflix.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.notflix.notflix.data.model.Movie
import com.notflix.notflix.domain.usecase.GetMovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Nicolas Dubiansky on 21/02/2025.
 */

data class MovieDetailUIState(
    val isLoading: Boolean = false,
    val movie: Movie? = null,
    val error: Exception? = null,
)

@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val getMovieDetailUseCase: GetMovieDetailUseCase) :
    ViewModel() {

    private val _movie = mutableStateOf(MovieDetailUIState())
    val movie: State<MovieDetailUIState> = _movie

    fun getMovieDetail(id: Int) {
        viewModelScope.launch {
            try {
                _movie.value = _movie.value.copy(isLoading = true, error = null)
                val movie = getMovieDetailUseCase.getMovieDetail(id)
                _movie.value = MovieDetailUIState(movie = movie)
            } catch (e: Exception) {
                _movie.value = _movie.value.copy(isLoading = false, error = e)
            }
        }
    }
}