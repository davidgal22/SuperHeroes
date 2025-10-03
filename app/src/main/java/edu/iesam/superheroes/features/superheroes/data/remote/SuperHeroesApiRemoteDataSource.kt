package edu.iesam.superheroes.features.superheroes.data.remote

import edu.iesam.superheroes.features.superheroes.domain.ErrorApp
import edu.iesam.superheroes.features.superheroes.domain.SuperHeroe

class SuperHeroesApiRemoteDataSource {

    fun getSuperHeroes(): Result<List<SuperHeroe>> {
       // return Result.failure(ErrorApp.ServerError)

            return Result.success(
                listOf(
                    SuperHeroe("1", "Spider-Man", "spider-man", "url_imagen"),
                    SuperHeroe("2", "Iron Man", "iron-man", "url_imagen")
                )
            )

    }

}

