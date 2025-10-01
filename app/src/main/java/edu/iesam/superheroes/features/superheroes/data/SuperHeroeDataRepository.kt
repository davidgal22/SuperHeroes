package edu.iesam.superheroes.features.superheroes.data

import edu.iesam.superheroes.features.superheroes.domain.SuperHeroe
import edu.iesam.superheroes.features.superheroes.domain.SuperHeroeRepository

class SuperHeroeDataRepository (
    private val apiRemoteDataSource : SuperHeroeDataRepository
): SuperHeroeRepository {
    override fun get(): List<SuperHeroe> {
        return apiRemoteDataSource.get()

    }
}
