package edu.iesam.superheroes.features.superheroes.domain

interface SuperHeroeRepository {
    fun get(): Result<List<SuperHeroe>>
}