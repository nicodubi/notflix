package com.notflix.notflix.presentation.screens.movieshome

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.notflix.notflix.data.model.Movie
import com.notflix.notflix.domain.usecase.ResultState

import com.notflix.notflix.presentation.viewmodel.MoviesViewModel
import androidx.compose.runtime.getValue
import com.notflix.notflix.presentation.common.LoadingContent

/**
 * Created by Nicolas Dubiansky on 27/11/2024.
 */

@Composable
fun MoviesHomeScreen(
    modifier: Modifier = Modifier,
    moviesViewModel: MoviesViewModel = hiltViewModel(),
    onNavigateToMovieDetail: (Movie) -> Unit
) {
    val moviesState = moviesViewModel.movies.value

    Box(modifier = Modifier.fillMaxSize()) {
        when (moviesState) {
            is ResultState.Loading -> {
                LoadingContent()
            }

            is ResultState.Success -> {
                MoviesList(movies = moviesState.data, onMovieClicked = {
                    onNavigateToMovieDetail(it)
                })
            }

            is ResultState.Error -> {}
        }


        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            contentColor = MaterialTheme.colorScheme.onPrimary,
            onClick = { moviesViewModel.refreshMovies() }) {
            Icon(
                imageVector = Icons.Filled.Refresh,
                contentDescription = "Refresh"
            )
        }
    }

}




