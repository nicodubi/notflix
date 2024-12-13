package com.notflix.notflix.presentation.screens.movieshome

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.lifecycle.viewmodel.compose.viewModel
import com.notflix.notflix.data.repository.MoviesRepositoryImpl
import com.notflix.notflix.data.source.local.MoviesLocalDatabase
import com.notflix.notflix.data.source.network.MoviesRemoteDataSourceAPI
import com.notflix.notflix.domain.usecase.GetMoviesUseCase
import com.notflix.notflix.presentation.viewmodel.MoviesViewModel

/**
 * Created by Nicolas Dubiansky on 27/11/2024.
 */

@Composable
fun MoviesHomeScreen(
    modifier: Modifier = Modifier,
    moviesViewModel: MoviesViewModel = hiltViewModel()
) {
    MoviesList(movies = moviesViewModel.movies)

}




