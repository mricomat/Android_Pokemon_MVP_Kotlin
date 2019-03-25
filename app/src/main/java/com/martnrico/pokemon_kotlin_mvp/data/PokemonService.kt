package com.martnrico.pokemon_kotlin_mvp.data

import com.martnrico.pokemon_kotlin_mvp.data.model.DataContainerListModel
import com.martnrico.pokemon_kotlin_mvp.data.model.PokemonModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Martín Rico Martínez on 22/03/2019.
 */
interface PokemonService {

    @GET("pokemon")
    fun getPokemonNames(@Query("limit") limit: Int): Single<DataContainerListModel>

    @GET("pokemon/{id}")
    fun getPokemonDetails(@Path("id") id: Int): Single<PokemonModel>

}