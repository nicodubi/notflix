package com.notflix.notflix.presentation.screens.movieshome


import android.content.res.Configuration
import android.text.TextUtils.TruncateAt
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.notflix.notflix.R
import com.notflix.notflix.data.model.Movie
import kotlin.math.roundToInt

/**
 * Created by Nicolas Dubiansky on 28/11/2024.
 */


@Composable
fun MovieRoundedContainer(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Surface(
        modifier = modifier.padding(16.dp),
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(size = 16.dp),
        color = MaterialTheme.colorScheme.onPrimary
    ) {
        content()
    }
}

@Composable
fun MovieRoundedCardContainer(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Card(
        modifier = modifier.padding(16.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onPrimary)
    ) {
        content()
    }
}

@Composable
fun MovieListItem(modifier: Modifier = Modifier, movie: Movie, onMovieClicked: () -> Unit) {
    MovieRoundedContainer(modifier = Modifier.clickable(onClick = onMovieClicked)) {
        Column(modifier = modifier.height(dimensionResource(R.dimen.movie_list_item_height))) {
            Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .weight(1f)
                        .padding(dimensionResource(R.dimen.padding_cards_small)),
                ) {
                    Text(
                        text = movie.title,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(bottom = dimensionResource(R.dimen.padding_card_space_elements))
                    )

                    Text(
                        text = movie.overview,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = movie.release_date,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "Average vote: ${movie.vote_average.roundToInt()}",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodyLarge
                    )


                    StarRaitingView(movie.vote_average.roundToInt())


                }


                movie.poster_path?.let {
                    Box {
                        AsyncImage(
                            modifier = Modifier
                                .fillMaxHeight()
                                .aspectRatio(3f / 4f),
                            contentScale = ContentScale.Crop,
                            model = it,
                            contentDescription = null,
                        )

                        Icon(
                            modifier = Modifier
                                .size(24.dp)
                                .align(Alignment.Center),
                            contentDescription = null,
                            imageVector = Icons.Rounded.Info,
                            tint = Color.White
                        )
                    }
                }


            }


        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun MovieListItemPreview() {
    val movie = Movie(
        title = "Batman",
        id = 1234,
        overview = "Batman and the Joker, fighting crime",
        vote_average = 7.212,
        release_date = "07/04/2024"
    )

    MovieListItem(
        movie = movie,
        onMovieClicked = {}
    )

}
