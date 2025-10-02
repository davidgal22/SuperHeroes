package edu.iesam.superheroes.features.superheroes.domain

sealed class ErrorApp : Throwable() {
    object networkError : ErrorApp()
    object serverError : ErrorApp()
}