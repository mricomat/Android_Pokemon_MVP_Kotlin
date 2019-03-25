package com.martnrico.pokemon_kotlin_mvp.ui.list.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.item_pokemon.view.*

/**
 * Created by Martín Rico Martínez on 22/03/2019.
 */
class ListViewHolder(private val mItemView: View, private val mItemClickListener: ItemClickListener) :
    RecyclerView.ViewHolder(mItemView) {

    private fun clear() {
        mItemView.pokemon_name.text = ""
    }

    fun onBind(name: String, position: Int) {
        clear()
        mItemView.pokemon_name.text = name
        mItemView.setOnClickListener { view ->
            mItemClickListener.onItemClick(mItemView, position, name)
        }
    }
}