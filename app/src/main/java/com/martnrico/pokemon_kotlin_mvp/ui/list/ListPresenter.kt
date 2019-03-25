package com.martnrico.pokemon_kotlin_mvp.ui.list

import com.martnrico.pokemon_kotlin_mvp.ui.base.BasePresenter

/**
 * Created by Martín Rico Martínez on 21/03/2019.
 */
interface ListPresenter<V : ListView> : BasePresenter<V> {

    fun loadPokemon()

    fun onPokemonClicked(name: String, id: Int)
}