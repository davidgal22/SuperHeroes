package edu.iesam.superheroes.features.superheroes.domain

interface SuperHeroeRepository {
    suspend fun findAll(): Result<List<SuperHeroe>>
}