package com.martnrico.pokemon_kotlin_mvp.ui.list

import com.martnrico.pokemon_kotlin_mvp.ui.base.BaseView

/**
 * Created by Martín Rico Martínez on 21/03/2019.
 */
interface ListView : BaseView {

    fun showListPokemonNames(pokemonNames: List<String>)

}