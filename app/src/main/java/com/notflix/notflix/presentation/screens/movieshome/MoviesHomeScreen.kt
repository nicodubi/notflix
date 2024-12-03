package com.notflix.notflix.presentation.screens.movieshome

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items

import androidx.lifecycle.viewmodel.compose.viewModel
import com.notflix.notflix.data.repository.MoviesRepositoryImpl
import com.notflix.notflix.data.source.local.MoviesLocalDatabase
import com.notflix.notflix.data.source.network.MoviesRemoteDataSourceAPI
import com.notflix.notflix.domain.usecase.GetMoviesUseCase
import com.notflix.notflix.presentation.viewmodel.MoviesViewModel
import com.notflix.notflix.presentation.viewmodel.MoviesViewModelFactory

/**
 * Created by Nicolas Dubiansky on 27/11/2024.
 */

@Composable
fun MoviesHomeScreen(
    modifier: Modifier = Modifier,
    moviesViewModel: MoviesViewModel = viewModel(
        factory = MoviesViewModelFactory(
            createGetMoviesUseCase()
        )
    )
) {
    MoviesList(movies = moviesViewModel.movies)

}

fun createGetMoviesUseCase() =
    GetMoviesUseCase(
        MoviesRepositoryImpl(
            moviesRemoteDataSource = MoviesRemoteDataSourceAPI(),
            moviesLocalDataSource = MoviesLocalDatabase()
        )
    )


