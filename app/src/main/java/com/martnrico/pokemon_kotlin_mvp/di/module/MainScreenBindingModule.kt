package com.martnrico.pokemon_kotlin_mvp.di.module

import android.support.v4.app.Fragment
import com.martnrico.pokemon_kotlin_mvp.di.component.DetailsComponent
import com.martnrico.pokemon_kotlin_mvp.ui.details.DetailsViewFragment
import com.martnrico.pokemon_kotlin_mvp.ui.list.ListViewFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

/**
 * Created by Martín Rico Martínez on 23/03/2019.
 */
@Module(subcomponents = [DetailsComponent::class])
abstract class MainScreenBindingModule {

    @ContributesAndroidInjector(modules = [ListScreenBindingModule::class])
    abstract fun provideListFragmentInjector(): ListViewFragment

    @Binds
    @IntoMap
    @FragmentKey(DetailsViewFragment::class)
    internal abstract fun bindDetailsInjector(builder: DetailsComponent.Builder): AndroidInjector.Factory<out Fragment>
}