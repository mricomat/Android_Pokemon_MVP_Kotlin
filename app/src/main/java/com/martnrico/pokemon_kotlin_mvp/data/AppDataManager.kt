package com.martnrico.pokemon_kotlin_mvp.data

import com.martnrico.pokemon_kotlin_mvp.data.model.DataContainerListModel
import com.martnrico.pokemon_kotlin_mvp.data.model.PokemonModel
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Martín Rico Martínez on 22/03/2019.
 */
@Singleton
class AppDataManager @Inject constructor(private val mPokemonApiHelper: PokemonApiHelper) : DataManager {

    override fun getPokemonNames(limit: Int): Single<DataContainerListModel> {
        return mPokemonApiHelper.getPokemonNames(limit)
    }

    override fun getPokemonDetails(id: Int): Single<PokemonModel> {
        return mPokemonApiHelper.getPokemonDetails(id)
    }

}