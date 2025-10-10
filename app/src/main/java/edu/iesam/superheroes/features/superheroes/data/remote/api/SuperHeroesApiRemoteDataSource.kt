package edu.iesam.superheroes.features.superheroes.data.remote.api

import edu.iesam.superheroes.core.api.ApiClient
import edu.iesam.superheroes.features.superheroes.domain.ErrorApp
import edu.iesam.superheroes.features.superheroes.domain.SuperHeroe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class SuperHeroesApiRemoteDataSource(private val apiClient: ApiClient) {

    suspend fun getSuperHeroes(): Result<List<SuperHeroe>> {
        // return Result.failure(ErrorApp.ServerError)
        //entran ApiModels
        //salen Models
        return withContext(Dispatchers.IO) {
            val apiService = apiClient.createService(SuperHeroApiService::class.java)
            val resultSuperHeroe = apiService.findAll()
            if (resultSuperHeroe.isSuccessful && resultSuperHeroe.errorBody() == null) {
                val listSuperHoerApiModel: List<SuperHeroApiModel> = resultSuperHeroe.body()!!
                val listSuperHero = listSuperHoerApiModel.map { superHeroApiModel ->
                    superHeroApiModel.toModel()
                }
                return@withContext Result.success(listSuperHero)

                // return Result.success(resultSuperHeroe.body()!!.map {
                //   it.toModel()
                //})
            } else {
                return@withContext Result.failure(ErrorApp.ServerError)

            }
        }


    }

}