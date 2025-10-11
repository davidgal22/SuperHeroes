package edu.iesam.superheroes.features.superheroes.data

import edu.iesam.superheroes.features.superheroes.data.remote.api.SuperHeroesApiRemoteDataSource
import edu.iesam.superheroes.features.superheroes.domain.SuperHeroe
import edu.iesam.superheroes.features.superheroes.domain.SuperHeroeRepository

class SuperHeroDataRepository(private val remote: SuperHeroesApiRemoteDataSource) :
    SuperHeroeRepository{

    override suspend fun findAll(): Result<List<SuperHeroe>> {
        return remote.getSuperHeroes()
    }
}