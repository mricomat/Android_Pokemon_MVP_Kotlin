package com.martnrico.pokemon_kotlin_mvp.di.component

import com.martnrico.pokemon_kotlin_mvp.PokemonApplication
import com.martnrico.pokemon_kotlin_mvp.di.module.ActivityBindingModule
import com.martnrico.pokemon_kotlin_mvp.di.module.PokemonApplicationModule
import com.martnrico.pokemon_kotlin_mvp.di.module.PokemonServiceModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Martín Rico Martínez on 21/03/2019.
 */
@Singleton
@Component(
    modules = [ActivityBindingModule::class, PokemonApplicationModule::class,
        AndroidSupportInjectionModule::class, PokemonServiceModule::class]
)
interface PokemonAppComponent : AndroidInjector<PokemonApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<PokemonApplication>()
}