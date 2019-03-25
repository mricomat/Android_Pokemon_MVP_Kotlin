package com.martnrico.pokemon_kotlin_mvp.ui

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.martnrico.pokemon_kotlin_mvp.R
import com.martnrico.pokemon_kotlin_mvp.di.ActivityScope
import com.martnrico.pokemon_kotlin_mvp.ui.details.DetailsViewFragment
import com.martnrico.pokemon_kotlin_mvp.ui.list.ListViewFragment
import javax.inject.Inject

/**
 * Created by Martín Rico Martínez on 21/03/2019.
 */
@ActivityScope
class ScreenNavigatorImpl @Inject constructor() : ScreenNavigator {

    private var mFragmentManager: FragmentManager? = null

    override fun init(activity: AppCompatActivity) {
        this.mFragmentManager = activity.supportFragmentManager
        val fragment: Fragment = ListViewFragment().newInstance()
        if (mFragmentManager != null) {
            if (mFragmentManager!!.fragments.size == 0) {
                mFragmentManager!!.beginTransaction()
                    .replace(R.id.screen_container, fragment)
                    .commit()
            }
        }
    }

    override fun pop(): Boolean {
        return mFragmentManager != null && mFragmentManager!!.popBackStackImmediate()
    }

    override fun goToPokemonDetails(name: String, id: Int) {
        if (mFragmentManager != null) {
            this.mFragmentManager!!.beginTransaction()
                .replace(R.id.screen_container, DetailsViewFragment().newInstance(name, id))
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroy(activity: AppCompatActivity) {
        mFragmentManager = null
    }
}