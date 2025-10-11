package edu.iesam.superheroes.features.superheroes.domain

class GetSuperHeroeUseCase(val repository: SuperHeroeRepository) {

    suspend operator fun invoke(): Result<List<SuperHeroe>> {
        return repository.findAll()
    }
}