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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

import com.notflix.notflix.presentation.viewmodel.MoviesViewModel

/**
 * Created by Nicolas Dubiansky on 27/11/2024.
 */

@Composable
fun MoviesHomeScreen(
    modifier: Modifier = Modifier,
    moviesViewModel: MoviesViewModel = hiltViewModel()
) {
    Box(modifier = Modifier.fillMaxSize()) {
        MoviesList(movies = moviesViewModel.movies)

        FloatingActionButton(
            modifier = Modifier.align(Alignment.BottomEnd).padding(16.dp),
            contentColor = MaterialTheme.colorScheme.onPrimary,
            onClick = { moviesViewModel.getMovies() }) {
            Icon(
                imageVector = Icons.Filled.Refresh,
                contentDescription = "Refresh"
            )
        }
    }

}




