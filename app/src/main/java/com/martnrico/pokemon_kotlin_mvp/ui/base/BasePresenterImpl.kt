package com.martnrico.pokemon_kotlin_mvp.ui.base

import com.martnrico.pokemon_kotlin_mvp.data.DataManager
import com.martnrico.pokemon_kotlin_mvp.utils.DisposableManager

/**
 * Created by Martín Rico Martínez on 21/03/2019.
 */
open class BasePresenterImpl<V : BaseView>(
    private var mDataManager: DataManager,
    private var mDisposableManager: DisposableManager
) :
    BasePresenter<V> {

    private var mMvpView: V? = null

    override fun onAttach(view: V) {
        mMvpView = view
    }

    override fun onDetach() {
        mDisposableManager.dispose()
        mMvpView = null
    }

    fun getMvpView(): V? {
        return mMvpView
    }

    fun isViewAttached(): Boolean {
        return mMvpView != null
    }
}