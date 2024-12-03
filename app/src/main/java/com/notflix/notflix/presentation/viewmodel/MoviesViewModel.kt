package com.notflix.notflix.presentation.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.notflix.notflix.data.Movie
import com.notflix.notflix.domain.usecase.GetMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Nicolas Dubiansky on 27/11/2024.
 */
class MoviesViewModel(val getMoviesUseCase: GetMoviesUseCase) : ViewModel() {

    private val _movies: MutableList<Movie> = mutableStateListOf()

    val movies: List<Movie>
        get() = _movies

    init {
        viewModelScope.launch{
            val movies = getMoviesUseCase.getFakeMovies()
            _movies.clear()
            _movies.addAll(movies)
        }
    }


}

//TODO this will change with HILT (DI)
class MoviesViewModelFactory(private val getMoviesUseCase: GetMoviesUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MoviesViewModel::class.java)) {
            return MoviesViewModel(getMoviesUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}