package com.notflix.notflix.di

import com.notflix.notflix.data.repository.MoviesRepository
import com.notflix.notflix.data.repository.MoviesRepositoryImpl
import com.notflix.notflix.data.source.local.MoviesLocalDataSource
import com.notflix.notflix.data.source.local.MoviesLocalDatabase
import com.notflix.notflix.data.source.network.MoviesRemoteDataSource
import com.notflix.notflix.data.source.network.MoviesRemoteDataSourceAPI
import com.notflix.notflix.domain.usecase.GetMoviesUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Nicolas Dubiansky on 13/12/2024.
 */


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    /*
    //It could be with @Provides or @Binds. If its @Provides change object instead of abstract class
    @Provides
    fun provideMoviesRepository(
        moviesRemoteDataSource: MoviesRemoteDataSource,
        moviesLocalDataSource: MoviesLocalDataSource
    ): MoviesRepository =
        MoviesRepositoryImpl(moviesRemoteDataSource, moviesLocalDataSource)*/

    @Binds
    @Singleton
    abstract fun bindsMoviesRepository(moviesRepositoryImpl: MoviesRepositoryImpl): MoviesRepository
}

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    fun provideMoviesLocalDataSource(): MoviesLocalDataSource = MoviesLocalDatabase()

    @Provides
    fun provideMoviesRemoteDataSource(): MoviesRemoteDataSource = MoviesRemoteDataSourceAPI()
}