package com.notflix.notflix.presentation.screens.movieshome

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.notflix.notflix.data.model.Movie

/**
 * Created by Nicolas Dubiansky on 28/11/2024.
 */

@Composable
fun MoviesList(modifier: Modifier = Modifier, movies: List<Movie>) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(items = movies) { movie ->
            MovieListItem(movie = movie)
        }
    }
}