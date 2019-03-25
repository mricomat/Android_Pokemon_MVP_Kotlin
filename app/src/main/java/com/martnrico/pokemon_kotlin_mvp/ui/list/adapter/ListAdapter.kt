package com.martnrico.pokemon_kotlin_mvp.ui.list.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.martnrico.pokemon_kotlin_mvp.R

/**
 * Created by Martín Rico Martínez on 22/03/2019.
 */
class ListAdapter(private var mPokemonListNames: ArrayList<String>, private val mItemClickListener: ItemClickListener) :
    RecyclerView.Adapter<ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent!!.context).inflate(R.layout.item_pokemon, parent, false)
        return ListViewHolder(view, mItemClickListener)
    }

    override fun onBindViewHolder(holder: ListViewHolder?, position: Int) {
        if (!mPokemonListNames.isEmpty()) {
            holder?.onBind(mPokemonListNames[position], position)
        }
    }

    override fun getItemCount(): Int {
        return mPokemonListNames.size
    }

    fun addList(pokemonNames: List<String>) {
        mPokemonListNames.addAll(pokemonNames)
        notifyDataSetChanged()
    }

}