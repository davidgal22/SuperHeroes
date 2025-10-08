package edu.iesam.superheroes.features.superheroes.data.remote.api

import edu.iesam.superheroes.core.api.ApiClient
import edu.iesam.superheroes.features.superheroes.domain.SuperHeroe

class SuperHeroesApiRemoteDataSource (private val apiClient: ApiClient){

    fun getSuperHeroes(): Result<List<SuperHeroe>> {
       // return Result.failure(ErrorApp.ServerError)
        //entran ApiModels
        //salen Models
       val apiService = apiClient.createService(SuperHeroApiService::class.java)
        apiService.findAll()
            return Result.success(
                listOf(
                    SuperHeroe("1", "Spider-Man", "spider-man", "url_imagen"),
                    SuperHeroe("2", "Iron Man", "iron-man", "url_imagen")
                )
            )

    }

}