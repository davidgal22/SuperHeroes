package edu.iesam.superheroes.features.superheroes.domain

interface SuperHeroeRepository {
    suspend fun get(): Result<List<SuperHeroe>>  // ← Añadir suspend
}