package com.martnrico.pokemon_kotlin_mvp.di.module

import com.martnrico.pokemon_kotlin_mvp.ui.list.ListPresenter
import com.martnrico.pokemon_kotlin_mvp.ui.list.ListPresenterImpl
import com.martnrico.pokemon_kotlin_mvp.ui.list.ListView
import com.martnrico.pokemon_kotlin_mvp.utils.DisposableManager
import dagger.Module
import dagger.Provides

/**
 * Created by Martín Rico Martínez on 23/03/2019.
 */
@Module
class ListScreenBindingModule {

    @Provides
    fun bindListPresenter(presenter: ListPresenterImpl<ListView>): ListPresenter<ListView> {
        return presenter
    }

    @Provides
    fun provideDisposableManager(): DisposableManager {
        return DisposableManager()
    }
}