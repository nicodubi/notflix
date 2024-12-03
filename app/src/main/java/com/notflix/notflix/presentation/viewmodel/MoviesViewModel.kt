package com.notflix.notflix.presentation.viewmodel

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.notflix.notflix.data.Movie
import com.notflix.notflix.domain.usecase.GetMoviesUseCase

/**
 * Created by Nicolas Dubiansky on 27/11/2024.
 */
class MoviesViewModel( val getMoviesUseCase: GetMoviesUseCase) : ViewModel() {

    private val _movies: MutableList<Movie> = getMoviesUseCase.getFakeMovies().toMutableStateList()

    val movies: List<Movie>
        get() = _movies



}

//TODO this will change with HILT (DI)
class MoviesViewModelFactory(private val getMoviesUseCase: GetMoviesUseCase) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MoviesViewModel::class.java)) {
            return MoviesViewModel(getMoviesUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}