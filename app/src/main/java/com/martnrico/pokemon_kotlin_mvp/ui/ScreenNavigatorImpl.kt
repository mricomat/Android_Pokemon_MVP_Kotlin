package com.martnrico.pokemon_kotlin_mvp.ui

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.martnrico.pokemon_kotlin_mvp.R
import com.martnrico.pokemon_kotlin_mvp.di.ActivityScope
import com.martnrico.pokemon_kotlin_mvp.ui.list.ListViewFragment
import javax.inject.Inject

/**
 * Created by Martín Rico Martínez on 21/03/2019.
 */
@ActivityScope
class ScreenNavigatorImpl @Inject constructor() : ScreenNavigator {

    private lateinit var mFragmentManager: FragmentManager

    override fun init(activity: AppCompatActivity) {
        this.mFragmentManager = activity.supportFragmentManager
        val fragment: Fragment = ListViewFragment().newInstance()
        if (mFragmentManager.fragments.size == 0) {
            mFragmentManager.beginTransaction()
                .replace(R.id.screen_container, fragment)
                .commit()
        }
    }


    override fun pop(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToPokemonDetails(name: String, id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroy(activity: AppCompatActivity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}