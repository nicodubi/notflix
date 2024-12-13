package com.notflix.notflix.presentation.screens

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.notflix.notflix.data.repository.MoviesRepository
import com.notflix.notflix.presentation.screens.movieshome.MoviesHomeScreen
import com.notflix.notflix.presentation.viewmodel.MoviesViewModel
import com.notflix.notflix.ui.theme.NotflixTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotflixAppContainer {
                MoviesHomeScreen()
            }
        }
    }
}


@Composable
fun NotflixAppContainer(content: @Composable () -> Unit) {
    NotflixTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Surface(
                modifier = Modifier.padding(innerPadding)
            ) {
                content()
            }
        }
    }
}

