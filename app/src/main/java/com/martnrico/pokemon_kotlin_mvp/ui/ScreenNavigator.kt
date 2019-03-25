package com.martnrico.pokemon_kotlin_mvp.ui

import android.support.v7.app.AppCompatActivity

/**
 * Created by Martín Rico Martínez on 21/03/2019.
 */
interface ScreenNavigator {

    fun init(activity: AppCompatActivity)

    fun pop(): Boolean

    fun goToPokemonDetails(name: String, id: Int)

    fun onDestroy(activity: AppCompatActivity)
}