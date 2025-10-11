package edu.iesam.superheroes.features.superheroes.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import edu.iesam.superheroes.R
import edu.iesam.superheroes.core.api.ApiClient
import edu.iesam.superheroes.features.superheroes.data.SuperHeroDataRepository

import edu.iesam.superheroes.features.superheroes.data.remote.api.SuperHeroesApiRemoteDataSource
import edu.iesam.superheroes.features.superheroes.domain.ErrorApp
import edu.iesam.superheroes.features.superheroes.domain.GetSuperHeroeUseCase
import edu.iesam.superheroes.features.superheroes.domain.SuperHeroe
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class SuperHeroesActivity : AppCompatActivity() {
    private val viewModel = SuperHeroesViewModel(
        GetSuperHeroeUseCase(
            SuperHeroDataRepository(
                SuperHeroesApiRemoteDataSource(ApiClient())
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        setupObserver()

viewModel.loadSuperHeroes()
    }

    private fun setupObserver() {
        val observer = Observer<SuperHeroesViewModel.UiState> { uiState ->
            if (uiState.isLoading) {
                //Muestro un spinner
            } else {
                //oculto spinner
            }
            // El viewmodel me pas el uiState
            if (uiState.error != null) {

            }else{

            }
            //uistate.error?.let{
                //visualizar pantalla de error
            //} ?:{
            //ocultar error
            //}

            uiState.superheroes?.let{ superheroes ->
                superheroes
            }
        }
        viewModel.uiState.observe(this, observer)

    }
}