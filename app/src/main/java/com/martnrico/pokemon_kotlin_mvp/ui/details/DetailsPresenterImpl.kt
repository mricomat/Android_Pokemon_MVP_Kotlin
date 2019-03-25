package com.martnrico.pokemon_kotlin_mvp.ui.details

import com.martnrico.pokemon_kotlin_mvp.data.DataManager
import com.martnrico.pokemon_kotlin_mvp.data.model.PokemonModel
import com.martnrico.pokemon_kotlin_mvp.ui.base.BasePresenterImpl
import com.martnrico.pokemon_kotlin_mvp.utils.DisposableManager
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by Martín Rico Martínez on 25/03/2019.
 */
class DetailsPresenterImpl<V : DetailsView> @Inject constructor(
    @Named("pokemon_name") private val mPokemonName: String,
    @Named("pokemon_id") private val mPokemonId: Int,
    private var mDataManager: DataManager,
    private var mDisposableManager: DisposableManager
) : BasePresenterImpl<V>(mDataManager, mDisposableManager), DetailsPresenter<V> {

    private val TOOLBAR_TITLE_FORMAT = "%s (#%s)"

    override fun onAttach(view: V) {
        super.onAttach(view)
        getPokemonDetails()
    }

    override fun getPokemonDetails() {
        mDisposableManager.add(
            mDataManager.getPokemonDetails(mPokemonId)
                .doOnSubscribe { getMvpView()!!.showLoading() }
                .doOnEvent { _, _ -> getMvpView()!!.hideLoading() }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ pokemonModel: PokemonModel ->
                    getMvpView()!!.showPokemonDetails(pokemonModel)
                }, {error:Throwable ->
                    getMvpView()!!.showError()
                })
        )
    }

    override fun getToolbarTitle(): String {
        return String.format(TOOLBAR_TITLE_FORMAT, mPokemonName, mPokemonId)
    }
}