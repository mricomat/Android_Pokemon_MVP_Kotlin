package com.martnrico.pokemon_kotlin_mvp.di.module

import com.martnrico.pokemon_kotlin_mvp.di.ActivityScope
import com.martnrico.pokemon_kotlin_mvp.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Martín Rico Martínez on 21/03/2019.
 */
@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(
        modules = [NavigationModule::class,
            MainScreenBindingModule::class]
    )
    @ActivityScope
    abstract fun provideMainActivityInjector(): MainActivity
}