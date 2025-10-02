package edu.iesam.superheroes.features.superheroes.domain

sealed class ErrorApp : Throwable() {
    object NetworkError : ErrorApp()
    object ServerError : ErrorApp()
}