package edu.iesam.superheroes.features.superheroes.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.superheroes.features.superheroes.domain.GetSuperHeroeUseCase
import edu.iesam.superheroes.features.superheroes.domain.SuperHeroe

class SuperHeroesViewModel(
    private val getsuperHeroeUseCase: GetSuperHeroeUseCase
) : ViewModel() {
    fun loadSuperHeroes(): Result<List<SuperHeroe>> {
        return getsuperHeroeUseCase()
    }

}