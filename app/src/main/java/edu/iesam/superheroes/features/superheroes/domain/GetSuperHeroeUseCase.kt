package edu.iesam.superheroes.features.superheroes.domain

class GetSuperHeroeUseCase(val superHeroeRepository: SuperHeroeRepository) {

    suspend operator fun invoke(): Result<List<SuperHeroe>> {
        return superHeroeRepository.get()
    }
}