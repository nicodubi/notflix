package com.notflix.notflix.presentation.screens.movieshome


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.notflix.notflix.R

/**
 * Created by Nicolas Dubiansky on 28/11/2024.
 */

@Composable
fun MovieListItem(modifier: Modifier = Modifier, title: String, year: Int) {
    Column (
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.padding_cards_small)),
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_card_space_elements))
        )

        Text(
            text = "$year",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}