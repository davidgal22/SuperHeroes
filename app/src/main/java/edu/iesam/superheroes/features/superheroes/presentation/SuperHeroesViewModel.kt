package edu.iesam.superheroes.features.superheroes.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.superheroes.features.superheroes.data.remote.api.SuperHeroesApiRemoteDataSource
import edu.iesam.superheroes.features.superheroes.domain.GetSuperHeroeUseCase
import edu.iesam.superheroes.features.superheroes.domain.SuperHeroe
import kotlinx.coroutines.launch

class SuperHeroesViewModel(private val dataSource: SuperHeroesApiRemoteDataSource) : ViewModel() {


    fun loadSuperHeroes() {
        viewModelScope.launch {
            //Ejecuta el caso de uso
            val superHeroes = dataSource.getSuperHeroes()
            //UI
        }


    }


}