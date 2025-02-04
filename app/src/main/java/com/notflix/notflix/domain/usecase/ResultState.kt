package com.notflix.notflix.domain.usecase

/**
 * Created by Nicolas Dubiansky on 30/01/2025.
 */
sealed class ResultState<out T> {
    object Loading : ResultState<Nothing>()
    data class Success<out T>(val data: T) : ResultState<T>()
    data class Error(val exception: Exception) : ResultState<Nothing>()
}