package com.notflix.notflix.presentation.screens.moviedetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.notflix.notflix.presentation.viewmodel.MoviesViewModel

/**
 * Created by Nicolas Dubiansky on 24/01/2025.
 */
@Composable
fun MovieDetailScreen(
    modifier: Modifier = Modifier,
    movieTitle: String,
    moviesViewModel: MoviesViewModel = hiltViewModel()
) {
    Box(Modifier.fillMaxSize()) {
        Button(modifier = Modifier
            .padding(16.dp)
            .align(Alignment.Center), onClick = {})
        {
            Text(text = movieTitle)
        }
    }
}
