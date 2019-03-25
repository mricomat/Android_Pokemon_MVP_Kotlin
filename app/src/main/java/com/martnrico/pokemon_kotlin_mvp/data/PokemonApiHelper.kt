package com.martnrico.pokemon_kotlin_mvp.data

import com.martnrico.pokemon_kotlin_mvp.data.model.DataContainerListModel
import com.martnrico.pokemon_kotlin_mvp.data.model.PokemonModel
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Martín Rico Martínez on 22/03/2019.
 */
@Singleton
class PokemonApiHelper @Inject constructor(
    private val mService: PokemonService,
    @Named("network_scheduler") val mScheduler: Scheduler
) {

    fun getPokemonNames(limit: Int): Single<DataContainerListModel> {
        return mService.getPokemonNames(limit).subscribeOn(mScheduler)
    }

    fun getPokemonDetails(id: Int): Single<PokemonModel> {
        return mService.getPokemonDetails(id).subscribeOn(mScheduler)
    }
}