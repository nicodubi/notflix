package com.notflix.notflix.presentation.screens.moviedetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.notflix.notflix.presentation.viewmodel.MovieDetailViewModel
import com.notflix.notflix.presentation.viewmodel.MoviesViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import coil3.compose.AsyncImage
import com.notflix.notflix.R
import com.notflix.notflix.presentation.common.LoadingContent
import com.notflix.notflix.presentation.screens.movieshome.StarRaitingView
import com.notflix.notflix.presentation.viewmodel.MovieDetailUIState
import timber.log.Timber
import kotlin.math.roundToInt


/**
 * Created by Nicolas Dubiansky on 24/01/2025.
 */
@Composable
fun MovieDetailScreen(
    movieId: Int,
    moviesViewModel: MovieDetailViewModel = hiltViewModel(),
) {
    val movieDetailUIState by moviesViewModel.movie
    LaunchedEffect(movieId) {
        moviesViewModel.getMovieDetail(movieId)
    }
    MovieDetailScreen(uiState = movieDetailUIState)
}

@Composable
fun MovieDetailScreen(
    modifier: Modifier = Modifier,
    uiState: MovieDetailUIState,
) {
    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            uiState.movie?.let {
                MoviePoster(posterPath = it.poster_path, it.title)
                MovieDetails(
                    title = it.title,
                    overview = it.overview,
                    voteAverage = it.vote_average
                )
            }

            if (uiState.isLoading) LoadingContent()
        }

    }
}

@Composable
fun MovieDetails(
    title: String,
    overview: String,
    voteAverage: Double,
    modifier: Modifier = Modifier,
) {
    val padding = dimensionResource(R.dimen.movie_details_section_padding_horizontal)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = padding)
    ) {
        val paddingTop = dimensionResource(R.dimen.movie_detail_padding_top_between_data)
        MovieDetailText(
            paddingTop = paddingTop,
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        MovieDetailText(
            paddingTop = paddingTop,
            text = overview,
            style = MaterialTheme.typography.titleMedium
        )

        MovieDetailText(
            paddingTop = paddingTop,
            text = stringResource(R.string.average_vote, voteAverage.roundToInt()),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        StarRaitingView(voteAverage.roundToInt())
    }
}

@Composable
fun MovieDetailText(
    text: String,
    paddingTop: Dp,
    style: androidx.compose.ui.text.TextStyle,
    fontWeight: FontWeight = FontWeight.Normal,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = Modifier
            .padding(top = paddingTop),
        text = text,
        style = style
    )
}

@Composable
fun MoviePoster(posterPath: String?, contentDescription: String, modifier: Modifier = Modifier) {
    AsyncImage(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        model = posterPath,
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop
    )
}
