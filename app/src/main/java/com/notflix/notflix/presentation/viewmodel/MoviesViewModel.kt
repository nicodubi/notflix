package com.notflix.notflix.presentation.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.notflix.notflix.data.model.Movie
import com.notflix.notflix.domain.usecase.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Nicolas Dubiansky on 27/11/2024.
 */
@HiltViewModel
class MoviesViewModel @Inject constructor(private val getMoviesUseCase: GetMoviesUseCase) :
    ViewModel() {

    private val _movies: MutableList<Movie> = mutableStateListOf()

    val movies: List<Movie>
        get() = _movies

    init {
        viewModelScope.launch {
            val movies = getMoviesUseCase.getFakeMovies()
            _movies.clear()
            _movies.addAll(movies)
        }
    }


}