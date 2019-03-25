package com.martnrico.pokemon_kotlin_mvp.di.module

import com.martnrico.pokemon_kotlin_mvp.ui.details.DetailsPresenter
import com.martnrico.pokemon_kotlin_mvp.ui.details.DetailsPresenterImpl
import com.martnrico.pokemon_kotlin_mvp.ui.details.DetailsView
import com.martnrico.pokemon_kotlin_mvp.utils.DisposableManager
import dagger.Module
import dagger.Provides

/**
 * Created by Martín Rico Martínez on 25/03/2019.
 */
@Module
class DetailsScreenBindinModule {

    @Provides
    fun bindDetailsPresenter(presenter: DetailsPresenterImpl<DetailsView>): DetailsPresenter<DetailsView> {
        return presenter
    }

    @Provides
    fun provideDisposableManager(): DisposableManager {
        return DisposableManager()
    }
}