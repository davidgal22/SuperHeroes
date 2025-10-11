package edu.iesam.superheroes.features.superheroes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.superheroes.features.superheroes.data.remote.api.SuperHeroesApiRemoteDataSource
import edu.iesam.superheroes.features.superheroes.domain.ErrorApp
import edu.iesam.superheroes.features.superheroes.domain.GetSuperHeroeUseCase
import edu.iesam.superheroes.features.superheroes.domain.SuperHeroe
import kotlinx.coroutines.launch

class SuperHeroesViewModel( val getAll: GetSuperHeroeUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiState

    fun loadSuperHeroes() {
        viewModelScope.launch {
            _uiState.value = UiState(isLoading = true)
           getAll().fold(
               {superheroes ->
               onSuccess( superheroes)
           },
               {error ->

                   onError(error as ErrorApp)}

           )

        }


    }
    private fun onSuccess(superheroes: List<SuperHeroe>){
        _uiState.value = UiState(isLoading = false, superheroes = superheroes)

    }
    private fun onError(error: ErrorApp){
        // Actualizamos el estado: Ya no carga, y tenemos un error
        _uiState.value = UiState(isLoading = false, error = error)
    }
    data class UiState(
        val error: ErrorApp? = null,
        val isLoading: Boolean = false,
        val superheroes : List<SuperHeroe>? = null
    )
}