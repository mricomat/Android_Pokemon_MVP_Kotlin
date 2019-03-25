package com.martnrico.pokemon_kotlin_mvp.ui.details

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.View
import com.martnrico.pokemon_kotlin_mvp.R
import com.martnrico.pokemon_kotlin_mvp.data.model.PokemonModel
import com.martnrico.pokemon_kotlin_mvp.ui.base.BaseFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.app_bar_layout.*
import kotlinx.android.synthetic.main.details_fragment.*
import javax.inject.Inject

/**
 * Created by Martín Rico Martínez on 25/03/2019.
 */
class DetailsViewFragment : BaseFragment(), DetailsView {

    companion object {
        const val POKEMON_NAME: String = "pokemon_name"
        const val POKEMON_ID: String = "pokemon_id"
    }

    @Inject
    lateinit var mPresenter: DetailsPresenter<DetailsView>

    fun newInstance(pokemonName: String, pokemonId: Int): Fragment {
        val bundle = Bundle()
        bundle.putString(POKEMON_NAME, pokemonName)
        bundle.putInt(POKEMON_ID, pokemonId)
        val fragment = DetailsViewFragment()
        fragment.arguments = bundle
        return fragment
    }

    override fun layoutRes(): Int {
        return R.layout.details_fragment
    }

    override fun onResume() {
        super.onResume()
        mPresenter.onAttach(this)
    }

    override fun onDestroy() {
        mPresenter.onDetach()
        super.onDestroy()
    }

    override fun fillViews() {
        initToolbar()
    }

    override fun showPokemonDetails(pokemonModel: PokemonModel) {
        pokemon_id.text = getString(R.string.pokemon_id, pokemonModel.id)
        pokemon_name.text = getString(R.string.pokemon_name, pokemonModel.name)
        pokemon_height.text = getString(R.string.pokemon_height, pokemonModel.height)
        pokemon_weight.text = getString(R.string.pokemon_weight, pokemonModel.weight)
        pokemon_base_experience.text = getString(R.string.pokemon_base_experience, pokemonModel.baseExperience)
        pokemon_shiny_text.text = getString(R.string.pokemon_shiny)

        Picasso.get().load(pokemonModel.sprites.frontDefault).into(pokemon_front_image)
        Picasso.get().load(pokemonModel.sprites.backDefault).into(pokemon_back_image)
        Picasso.get().load(pokemonModel.sprites.frontShiny).into(pokemon_shiny_front)
        Picasso.get().load(pokemonModel.sprites.backShiny).into(pokemon_shiny_back)
    }

    override fun showLoading() {
        progress_bar.visibility = View.VISIBLE
        pokemon_details_layout.visibility = View.GONE
    }

    override fun hideLoading() {
        progress_bar.visibility = View.GONE
        pokemon_details_layout.visibility = View.VISIBLE
    }

    override fun showError() {
        Snackbar.make(coordinator_layout, getString(R.string.generic_error), Snackbar.LENGTH_SHORT)
            .setAction(getString(R.string.generic_retry)) { mPresenter.getPokemonDetails() }
            .show()
    }

    private fun initToolbar() {
        if (toolbar != null) {
            toolbar.title = mPresenter.getToolbarTitle()
        }
    }
}