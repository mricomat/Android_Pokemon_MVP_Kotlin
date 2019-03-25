package com.martnrico.pokemon_kotlin_mvp.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.LayoutRes
import android.view.ViewGroup
import butterknife.ButterKnife
import com.martnrico.pokemon_kotlin_mvp.R
import com.martnrico.pokemon_kotlin_mvp.ui.ScreenNavigator
import dagger.android.support.DaggerAppCompatActivity
import java.util.*
import javax.inject.Inject

/**
 * Created by Martín Rico Martínez on 21/03/2019.
 */
abstract class BaseActivity : DaggerAppCompatActivity() {

    companion object {
        const val INSTANCE_ID_KEY = "instance_id"
    }

    @Inject lateinit var mScreenNavigator: ScreenNavigator

    private var mInstanceId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        mInstanceId = if (savedInstanceState != null) {
            savedInstanceState.getString(INSTANCE_ID_KEY)
        } else {
            UUID.randomUUID().toString()
        }
        super.onCreate(savedInstanceState)

        setContentView(layoutRes())
        ButterKnife.bind(this)

        mScreenNavigator.init(this)
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState?.putString(INSTANCE_ID_KEY, mInstanceId)
    }

    @LayoutRes
    protected abstract fun layoutRes(): Int

    fun getInstanceId() : String? {
        return  this.mInstanceId
    }


}