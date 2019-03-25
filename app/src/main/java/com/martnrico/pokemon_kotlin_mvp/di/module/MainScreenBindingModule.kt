package com.martnrico.pokemon_kotlin_mvp.di.module

import com.martnrico.pokemon_kotlin_mvp.ui.list.ListViewFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Martín Rico Martínez on 23/03/2019.
 */
@Module
abstract class MainScreenBindingModule {

    @ContributesAndroidInjector(modules = [ListScreenBindingModule::class])
    abstract fun provideListFragmentInjector(): ListViewFragment
}