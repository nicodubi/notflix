package com.notflix.notflix.data.source.network

import com.notflix.notflix.data.model.Movie
import com.notflix.notflix.data.source.network.model.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Nicolas Dubiansky on 14/12/2024.
 */
interface MoviesNetworkServices {

    @GET("search/movie")
    suspend fun getMovies(@Query("query") query: String): MoviesResponse
}