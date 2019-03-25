package com.martnrico.pokemon_kotlin_mvp.data.model

/**
 * Created by Martín Rico Martínez on 24/03/2019.
 */

data class PokemonSpritesModel  (
    val frontDefault: String, val frontShiny: String, val frontFemale: String,
    val frontShinyFemale: String, val backDefault: String, val backShiny: String,
    val backFemale: String, val backShinyFemale: String
)