package edu.iesam.superheroes.features.superheroes.data.remote.api

import edu.iesam.superheroes.features.superheroes.domain.SuperHeroe

fun SuperHeroApiModel.toModel(): SuperHeroe {
   return SuperHeroe(this.id,
       this.name,
       this.slug,
       this.images.md)

}