package com.notflix.notflix.presentation.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.notflix.notflix.presentation.screens.moviedetail.MovieDetailScreen

import com.notflix.notflix.presentation.screens.movieshome.MoviesHomeScreen
import com.notflix.notflix.ui.theme.NotflixTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @kotlinx.serialization.Serializable
    object MoviesHomeScreenRoute

    @kotlinx.serialization.Serializable
    data class MovieDetailScreenRoute(val movieTitle: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotflixAppContainer {
                NotflixAppNavigation()
            }
        }
    }
}

@Composable
fun NotflixAppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MainActivity.MoviesHomeScreenRoute) {
        composable<MainActivity.MoviesHomeScreenRoute> {
            MoviesHomeScreen(onNavigateToMovieDetail = {
                navController.navigate(route = MainActivity.MovieDetailScreenRoute(movieTitle = it.title))
            })
        }

        composable<MainActivity.MovieDetailScreenRoute> {backStackEntry ->
            val movieDetailScreen : MainActivity.MovieDetailScreenRoute = backStackEntry.toRoute()
            MovieDetailScreen(movieTitle = movieDetailScreen.movieTitle)
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

