package edu.iesam.superheroes.features.superheroes.domain

interface SuperHeroeRepository {
    fun get(): List<SuperHeroe>
}