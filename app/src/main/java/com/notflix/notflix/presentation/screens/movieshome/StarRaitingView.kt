package com.notflix.notflix.presentation.screens.movieshome

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Created by Nicolas Dubiansky on 21/12/2024.
 */

@Composable
fun StarRaitingView(stars : Number){
    Row {
        for (i in 1..stars  .toInt()) {
            Icon(
                modifier = Modifier.size(16.dp),
                imageVector = Icons.Filled.Star,
                contentDescription = "Stars",
                tint = Color.Yellow

            )
        }
    }
}