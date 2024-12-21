package com.notflix.notflix.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.notflix.notflix.BuildConfig
import com.notflix.notflix.data.source.network.MoviesNetworkServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Nicolas Dubiansky on 14/12/2024.
 */


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    // TODO implements with Flavours DEV / RELEASE BASE URLs
    private const val BASE_URL = "https://api.themoviedb.org/3/"

    //TODO must be in a secret file, but for this educational project it's fine with Flavors
    private const val API_KEY = BuildConfig.API_KEY

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(ApiKeyInterceptor(API_KEY))
            .addInterceptor(logging)
            .build()
    }

    class ApiKeyInterceptor(private val apiKey: String) : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val originalRequest = chain.request()
            val modifiedRequest = originalRequest.newBuilder()
                .addHeader("Authorization", "Bearer $apiKey")
                .build()
            return chain.proceed(modifiedRequest)
        }
    }


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }


    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): MoviesNetworkServices {
        return retrofit.create(MoviesNetworkServices::class.java)
    }
}