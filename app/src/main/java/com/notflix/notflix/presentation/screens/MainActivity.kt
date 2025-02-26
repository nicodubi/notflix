package com.notflix.notflix.presentation.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
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
    data class MovieDetailScreenRoute(val movieId: Int)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotflixTheme {
                NotflixAppNavGraph()
            }
        }
    }
}

@Composable
fun NotflixAppNavGraph() {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()

    NavHost(navController = navController, startDestination = MainActivity.MoviesHomeScreenRoute) {
        composable<MainActivity.MoviesHomeScreenRoute> {
            MoviesHomeScreen(onNavigateToMovieDetail = {
                navController.navigate(route = MainActivity.MovieDetailScreenRoute(movieId = it.id))
            })
        }

        composable<MainActivity.MovieDetailScreenRoute> {backStackEntry ->
            val movieDetailScreen : MainActivity.MovieDetailScreenRoute = backStackEntry.toRoute()
            MovieDetailScreen(movieId = movieDetailScreen.movieId)
        }

    }
}



