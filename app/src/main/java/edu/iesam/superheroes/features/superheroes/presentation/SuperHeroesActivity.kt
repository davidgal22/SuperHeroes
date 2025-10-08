package edu.iesam.superheroes.features.superheroes.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.iesam.superheroes.R
import edu.iesam.superheroes.features.superheroes.data.SuperHeroeDataRepository
import edu.iesam.superheroes.features.superheroes.data.remote.api.SuperHeroesApiRemoteDataSource
import edu.iesam.superheroes.features.superheroes.domain.ErrorApp
import edu.iesam.superheroes.features.superheroes.domain.GetSuperHeroeUseCase
import edu.iesam.superheroes.features.superheroes.domain.SuperHeroe

class SuperHeroesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //conexion

        val api = SuperHeroesApiRemoteDataSource()
        val repository = SuperHeroeDataRepository(api)
        val useCase = GetSuperHeroeUseCase(repository)
        val viewModel = SuperHeroesViewModel(useCase)
        val result = viewModel.loadSuperHeroes()


        result.fold(
            {superheroes ->
                loadSuccess(superheroes)
            },
            {error->

                loadFailure(error as ErrorApp)}
        )

    }
    private fun loadSuccess(superheroes: List<SuperHeroe>) {
        superheroes.forEach { superhero ->
            Log.d("@dev", "ID: ${superhero.id}, Nombre: ${superhero.name}")
        }
    }

    private fun loadFailure(errorApp: ErrorApp) {
        when (errorApp) {
            is ErrorApp.NetworkError -> Log.e("@dev", "Error: Sin conexión a internet")
            is ErrorApp.ServerError -> Log.e("@dev", "Error: Servidor no disponible")
        }
    }
}