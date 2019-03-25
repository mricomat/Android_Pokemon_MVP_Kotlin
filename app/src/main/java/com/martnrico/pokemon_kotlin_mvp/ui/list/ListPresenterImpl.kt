package com.martnrico.pokemon_kotlin_mvp.ui.list

import com.martnrico.pokemon_kotlin_mvp.data.DataManager
import com.martnrico.pokemon_kotlin_mvp.data.model.DataContainerListModel
import com.martnrico.pokemon_kotlin_mvp.ui.ScreenNavigator
import com.martnrico.pokemon_kotlin_mvp.ui.base.BasePresenterImpl
import com.martnrico.pokemon_kotlin_mvp.utils.DisposableManager
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.*
import javax.inject.Inject

/**
 * Created by Martín Rico Martínez on 21/03/2019.
 */
class ListPresenterImpl<V : ListView> @Inject constructor(
    private var mScreenNavigator: ScreenNavigator,
    private var mDataManager: DataManager,
    private var mDisposableManager: DisposableManager
) :
    BasePresenterImpl<V>(mDataManager, mDisposableManager), ListPresenter<V> {

    override fun onAttach(view: V) {
        super.onAttach(view)
        loadPokemon()
    }

    override fun loadPokemon() {
        mDisposableManager.add(
            mDataManager.getPokemonNames(150)
                .doOnSubscribe { getMvpView()!!.showLoading() }
                .doOnEvent { _, _ -> getMvpView()!!.hideLoading() }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ dataContainerListModel ->
                    getMvpView()!!.showListPokemonNames(
                        getPokemonListFromResults(dataContainerListModel)
                    )
                },
                    { getMvpView()!!.showError() })
        )
    }

    override fun onPokemonClicked(name: String, id: Int) {
        mScreenNavigator.goToPokemonDetails(name, id)
    }

    private fun getPokemonListFromResults(dataContainerListModel: DataContainerListModel): List<String> {
        val results = dataContainerListModel.results
        val pokemonNames = ArrayList<String>()
        for (result in results) {
            pokemonNames.add(result.name.substring(0, 1).toUpperCase() + result.name.substring(1))
        }
        return pokemonNames
    }
}