package edu.iesam.superheroes.core.api

import edu.iesam.superheroes.features.superheroes.data.remote.api.SuperHeroApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    private val Base_URL = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/"

    private val retrofit  = Retrofit.Builder()
    .baseUrl(Base_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

    fun <T> createService(typeClass:Class<T>) : T{
        return retrofit.create(typeClass)

    }


}