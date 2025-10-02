package edu.iesam.superheroes.features.superheroes.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.iesam.superheroes.R
import edu.iesam.superheroes.features.superheroes.data.SuperHeroeDataRepository
import edu.iesam.superheroes.features.superheroes.data.remote.SuperHeroesApiRemoteDataSource
import edu.iesam.superheroes.features.superheroes.domain.GetSuperHeroeUseCase

class SuperHeroesListActivity : AppCompatActivity() {
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
        val repository= SuperHeroeDataRepository(api)
        val useCase = GetSuperHeroeUseCase(repository)
        val viewModel = SuperHeroesListViewModel(useCase)

        val result = viewModel.loadSuperHeroes()
        val superHeroes = result.getOrNull()

        Log.d ("@dev", "Superheroes encontrados: ${superHeroes?.size}")
    }
}