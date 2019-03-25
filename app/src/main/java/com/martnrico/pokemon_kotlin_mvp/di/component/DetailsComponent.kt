package com.martnrico.pokemon_kotlin_mvp.di.component

import com.martnrico.pokemon_kotlin_mvp.di.module.DetailsScreenBindinModule
import com.martnrico.pokemon_kotlin_mvp.ui.details.DetailsViewFragment
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjector
import javax.inject.Named

/**
 * Created by Martín Rico Martínez on 25/03/2019.
 */
@Subcomponent(modules = [DetailsScreenBindinModule::class])
interface DetailsComponent : AndroidInjector<DetailsViewFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<DetailsViewFragment>() {

        @BindsInstance
        abstract fun bindPokemonName(@Named("pokemon_name") pokemonName: String)

        @BindsInstance
        abstract fun bindPokemonId(@Named("pokemon_id") pokemonId: Int)

        override fun seedInstance(instance: DetailsViewFragment) {
            bindPokemonName(instance.arguments.getString(DetailsViewFragment.POKEMON_NAME))
            bindPokemonId(instance.arguments.getInt(DetailsViewFragment.POKEMON_ID))
        }
    }
}