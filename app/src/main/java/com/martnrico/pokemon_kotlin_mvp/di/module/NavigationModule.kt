package com.martnrico.pokemon_kotlin_mvp.di.module

import com.martnrico.pokemon_kotlin_mvp.ui.ScreenNavigator
import com.martnrico.pokemon_kotlin_mvp.ui.ScreenNavigatorImpl
import dagger.Binds
import dagger.Module

/**
 * Created by Martín Rico Martínez on 21/03/2019.
 */
@Module
abstract class NavigationModule {

    @Binds
    abstract fun provideScreenNavigator(screenNavigator: ScreenNavigatorImpl): ScreenNavigator
}