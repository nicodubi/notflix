package com.notflix.notflix.presentation.screens.movieshome

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.notflix.notflix.data.model.Movie

import com.notflix.notflix.presentation.viewmodel.MoviesViewModel
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.notflix.notflix.presentation.common.LoadingContent
import com.notflix.notflix.presentation.viewmodel.HomeMoviesUIState
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.notflix.notflix.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

/**
 * Created by Nicolas Dubiansky on 27/11/2024.
 */

/**
 * This composable is StateFul: is in charge to get the state from the ViewModel and pass it to the UI.
 *
 * @param moviesViewModel ViewModel that handles the business logic of this screen
 * @param snackbarHostState State that holds the snackbar host state
 * @param onNavigateToMovieDetail Callback that is triggered when a movie is clicked
 */
@Composable
fun MoviesHomeScreen(
    moviesViewModel: MoviesViewModel = hiltViewModel(),
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
    onNavigateToMovieDetail: (Movie) -> Unit
) {
    val homeMoviesUIState by moviesViewModel.movies
    MoviesHomeScreen(
        uiState = homeMoviesUIState,
        snackbarHostState = snackbarHostState,
        onNavigateToMovieDetail = onNavigateToMovieDetail,
        onRefreshMovies = { moviesViewModel.refreshMovies() }
    )


}


/**
 * Displays HomeScreen State
 * This composable is StateLess: is not coupled to any specific state management.
 *
 */
@Composable
fun MoviesHomeScreen(
    uiState: HomeMoviesUIState,
    snackbarHostState: SnackbarHostState,
    onNavigateToMovieDetail: (Movie) -> Unit,
    onRefreshMovies: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            MoviesList(movies = uiState.movies, onMovieClicked = {
                onNavigateToMovieDetail(it)
            })

            uiState.error?.let {
                LaunchedEffect(uiState.error) {
                    snackbarHostState.showSnackbar(message = it.message ?: "Unknown Error")
                }
            }

            if (uiState.isLoading) LoadingContent()
            val refreshMessage = stringResource(R.string.refresh)
            FloatingActionButton(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp),
                contentColor = MaterialTheme.colorScheme.onPrimary,
                onClick = {
                    onRefreshMovies()
                    showSnackbarRefreshing(
                        coroutineScope = coroutineScope,
                        snackbarHostState = snackbarHostState,
                        message = refreshMessage
                    )
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Refresh,
                    contentDescription = "Refresh"
                )
            }
        }
    }
}

fun showSnackbarRefreshing(
    coroutineScope: CoroutineScope,
    snackbarHostState: SnackbarHostState,
    message : String
) {
    coroutineScope.launch {
        snackbarHostState.showSnackbar(message)
    }
}




