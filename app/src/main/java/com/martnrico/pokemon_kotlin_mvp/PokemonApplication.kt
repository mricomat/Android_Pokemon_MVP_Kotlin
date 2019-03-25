package com.martnrico.pokemon_kotlin_mvp

import android.app.Activity
import android.app.Application
import android.support.v4.app.Fragment
import com.martnrico.pokemon_kotlin_mvp.di.component.DaggerPokemonAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by Martín Rico Martínez on 21/03/2019.
 */
class PokemonApplication: Application(), HasSupportFragmentInjector, HasActivityInjector {

    @Inject lateinit var mActivityInjector: DispatchingAndroidInjector<Activity>

    @Inject lateinit var mFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate() {
        super.onCreate()
        DaggerPokemonAppComponent.builder().create(this).inject(this)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return mFragmentInjector
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return mActivityInjector
    }
}