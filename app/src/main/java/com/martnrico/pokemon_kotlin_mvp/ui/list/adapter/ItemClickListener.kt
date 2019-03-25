package com.martnrico.pokemon_kotlin_mvp.ui.list.adapter

import android.view.View

/**
 * Created by Martín Rico Martínez on 22/03/2019.
 */
interface ItemClickListener {

    fun onItemClick(view: View, position: Int, name: String)
}