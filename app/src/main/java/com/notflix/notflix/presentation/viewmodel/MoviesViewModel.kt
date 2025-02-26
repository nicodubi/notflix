package com.notflix.notflix.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.notflix.notflix.data.model.Movie
import com.notflix.notflix.domain.usecase.GetMoviesUseCase
import com.notflix.notflix.domain.usecase.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Nicolas Dubiansky on 27/11/2024.
 */

data class HomeMoviesUIState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: Exception? = null,
)

@HiltViewModel
class MoviesViewModel @Inject constructor(private val getMoviesUseCase: GetMoviesUseCase) :
    ViewModel() {


    private val _movies = mutableStateOf(HomeMoviesUIState())
    val movies: State<HomeMoviesUIState>
        get() = _movies

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            try {
                _movies.value = _movies.value.copy(isLoading = true, error = null)
                val movies = getMoviesUseCase.getMovies()
                _movies.value = HomeMoviesUIState(movies = movies)
            } catch (e: Exception) {
                Timber.d(e)
                _movies.value = _movies.value.copy(isLoading = false, error = e)

            }

        }
    }

    fun refreshMovies() {
        getMovies()
    }

}