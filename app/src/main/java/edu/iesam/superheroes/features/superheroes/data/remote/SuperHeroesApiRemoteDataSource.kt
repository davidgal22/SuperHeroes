package edu.iesam.superheroes.features.superheroes.data.remote

import edu.iesam.superheroes.features.superheroes.domain.ErrorApp
import edu.iesam.superheroes.features.superheroes.domain.SuperHeroe

class SuperHeroesApiRemoteDataSource {

    fun getSuperHeroes(): Result<List<SuperHeroe>> {
        val networkError: Boolean =false
        val serverError: Boolean = false
        if (networkError) {
            return Result.failure(ErrorApp.NetworkError)
        } else if (serverError) {
            return Result.failure(ErrorApp.ServerError)
        } else {
            return Result.success(
                listOf(
                    SuperHeroe("1", "Spider-Man", "spider-man", "url_imagen"),
                    SuperHeroe("2", "Iron Man", "iron-man", "url_imagen")
                )
            )

        }

    }

}