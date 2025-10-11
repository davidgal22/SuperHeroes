package edu.iesam.superheroes.features.superheroes.data.remote.api

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface SuperHeroApiService {
    @GET("all.json")
    suspend fun findAll(): Response<List<SuperHeroApiModel>>

    @GET("id/{superheroId}.json")
   suspend fun finById(@Path("superheroId") id: String): SuperHeroApiModel
}