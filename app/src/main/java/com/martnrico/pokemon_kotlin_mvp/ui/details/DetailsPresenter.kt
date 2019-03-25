package com.martnrico.pokemon_kotlin_mvp.ui.details

import com.martnrico.pokemon_kotlin_mvp.ui.base.BasePresenter

/**
 * Created by Martín Rico Martínez on 25/03/2019.
 */
interface DetailsPresenter<V : DetailsView> : BasePresenter<V> {

    fun getPokemonDetails()

    fun getToolbarTitle(): String
}