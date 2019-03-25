package com.martnrico.pokemon_kotlin_mvp.ui.details

import com.martnrico.pokemon_kotlin_mvp.data.model.PokemonModel
import com.martnrico.pokemon_kotlin_mvp.ui.base.BaseView

/**
 * Created by Martín Rico Martínez on 25/03/2019.
 */
interface DetailsView :BaseView{

    fun showPokemonDetails(pokemonModel: PokemonModel)

}