package com.martnrico.pokemon_kotlin_mvp.di.module

import com.martnrico.pokemon_kotlin_mvp.data.AppDataManager
import com.martnrico.pokemon_kotlin_mvp.data.DataManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Martín Rico Martínez on 23/03/2019.
 */
@Module
class PokemonApplicationModule {

    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }
}