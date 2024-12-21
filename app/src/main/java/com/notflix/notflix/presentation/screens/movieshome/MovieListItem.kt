package com.notflix.notflix.presentation.screens.movieshome


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import com.notflix.notflix.R
import com.notflix.notflix.data.model.Movie

/**
 * Created by Nicolas Dubiansky on 28/11/2024.
 */

@Composable
fun MovieListItem(modifier: Modifier = Modifier, movie: Movie) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.padding_cards_small)),
    ) {
        Text(
            text = movie.title,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_card_space_elements))
        )

        Text(
            text = movie.overview,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = movie.release_date,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "Average vote: ${movie.vote_average}",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyLarge
        )
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(R.dimen.divider_padding_between_items)),
            thickness = dimensionResource(R.dimen.thickness_divider),
            color = Color.Red


        )
    }
}