package com.martnrico.pokemon_kotlin_mvp.ui.list

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.martnrico.pokemon_kotlin_mvp.R
import com.martnrico.pokemon_kotlin_mvp.ui.base.BaseFragment
import com.martnrico.pokemon_kotlin_mvp.ui.list.adapter.ItemClickListener
import com.martnrico.pokemon_kotlin_mvp.ui.list.adapter.ListAdapter
import kotlinx.android.synthetic.main.app_bar_layout.*
import kotlinx.android.synthetic.main.list_fragment.*
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

/**
 * Created by Martín Rico Martínez on 21/03/2019.
 */
class ListViewFragment : BaseFragment(), ListView, ItemClickListener {

    companion object {
        private const val INSTANCE_ID = "instance_id"
    }

    @Inject
    lateinit var mPresenter: ListPresenter<ListView>
    private lateinit var mAdapter: ListAdapter

    fun newInstance(): Fragment {
        val bundle = Bundle()
        bundle.putString(INSTANCE_ID, UUID.randomUUID().toString())
        val fragment = ListViewFragment()
        fragment.arguments = bundle
        return fragment
    }

    override fun layoutRes(): Int {
        return R.layout.list_fragment
    }

    override fun onResume() {
        super.onResume()
        mPresenter.onAttach(this)
    }

    override fun onDetach() {
        mPresenter.onDetach()
        super.onDetach()
    }

    override fun showLoading() {
        if (!swipe_refresh_layout.isRefreshing) {
            swipe_refresh_layout.isRefreshing = true
        }
    }

    override fun hideLoading() {
        swipe_refresh_layout.isRefreshing = false
    }

    override fun showError() {
        Snackbar.make(linear_layout, resources.getString(R.string.generic_error), Snackbar.LENGTH_SHORT)
            .setAction(resources.getString(R.string.generic_retry)) { mPresenter.loadPokemon() }.show()
    }

    override fun showListPokemonNames(pokemonNames: List<String>) {
        mAdapter.addList(pokemonNames)
    }

    override fun fillViews() {
        initToolbar()
        initSwipeRefreshLayout()
        initRecyclerView()
    }

    private fun initSwipeRefreshLayout() {
        swipe_refresh_layout!!.setColorSchemeResources(R.color.colorAccent)
    }

    private fun initToolbar() {
        if (toolbar != null) {
            toolbar.title = getString(R.string.app_name)
        }
    }

    private fun initRecyclerView() {
        mAdapter = ListAdapter(ArrayList(), this)
        recycler_view!!.adapter = mAdapter
        recycler_view!!.layoutManager = LinearLayoutManager(context)
    }

    override fun onItemClick(view: View, position: Int, name: String) {
        mPresenter.onPokemonClicked(name, position + 1)
    }

}