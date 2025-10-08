package edu.iesam.superheroes.features.superheroes.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Path


interface SuperHeroApiService {
    @GET("all.json")
    fun findAll():List<SuperHeroApiModel>

    @GET("id/{superheroId}.json")
    fun finById(@Path("superheroId") id: String): SuperHeroApiModel
}