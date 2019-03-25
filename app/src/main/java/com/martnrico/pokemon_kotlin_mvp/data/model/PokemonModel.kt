package com.martnrico.pokemon_kotlin_mvp.data.model

/**
 * Created by Martín Rico Martínez on 24/03/2019.
 */
data class PokemonModel(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val sprites: PokemonSpritesModel,
    val baseExperience: Int
)