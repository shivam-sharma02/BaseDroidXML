package com.example.basedroidxml.utils

sealed class APIState<out E>{
    data class Success<out T>(val data: T) : APIState<T>()
    data class Error(val exception: String) : APIState<Nothing>()
    data object Loading : APIState<Nothing>()
}