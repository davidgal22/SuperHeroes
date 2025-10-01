package edu.iesam.superheroes.features.superheroes.data.remote

import edu.iesam.superheroes.features.superheroes.domain.SuperHeroe

class SuperHeroesApiRemoteDataSource {

    fun getSuperHeroes(): Result<List<SuperHeroe>> {
        return Result.success(listOf(SuperHeroe("")))
    }

}