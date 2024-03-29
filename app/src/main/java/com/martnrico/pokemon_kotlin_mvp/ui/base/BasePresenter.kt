package com.martnrico.pokemon_kotlin_mvp.ui.base

/**
 * Created by Martín Rico Martínez on 21/03/2019.
 */
interface BasePresenter<V> {

    fun onAttach(view: V)

    fun onDetach()
}