package com.padcmyanmar.padc9.plant_app.activities

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcmyanmar.padc9.plant_app.R
import com.padcmyanmar.padc9.plant_app.adapters.PlantListAdapter
import com.padcmyanmar.padc9.plant_app.data.vos.PlantVO
import com.padcmyanmar.padc9.plant_app.mvp.presenters.PlantListPresenter
import com.padcmyanmar.padc9.plant_app.mvp.views.PlantListView
import kotlinx.android.synthetic.main.list_view.*

class PlantListActivity : BaseActivity(), PlantListView {

    override fun displayPlantList(plantList: List<PlantVO>) {
        mAdapter.setNewData(plantList.toMutableList())
    }

    override fun displayError(errorMessage: String) {

    }

    override fun navigateToNavigate(plantId: Int) {
        startActivity(DetailActivity.newIntent(applicationContext, plantId))
    }

    private lateinit var mPresenter: PlantListPresenter
    private lateinit var mAdapter: PlantListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_view)

        mPresenter = ViewModelProviders.of(this).get(PlantListPresenter::class.java)
        mPresenter.init(this)
        mAdapter = PlantListAdapter(mPresenter)

        with(rv_recycler) {
            rv_recycler.setHasFixedSize(true)
            rv_recycler.layoutManager = LinearLayoutManager(applicationContext)
            rv_recycler.adapter = mAdapter

        }
        mPresenter.onUiReady(this)
    }

}