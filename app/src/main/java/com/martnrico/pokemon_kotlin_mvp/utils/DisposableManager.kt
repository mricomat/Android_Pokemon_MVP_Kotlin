package com.martnrico.pokemon_kotlin_mvp.utils

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Martín Rico Martínez on 22/03/2019.
 */
class DisposableManager {

    private final val compositeDisposable = CompositeDisposable()

    fun add(vararg disposables: Disposable) {
        compositeDisposable.addAll(*disposables)
    }

    fun dispose() {
        compositeDisposable.clear()
    }
}