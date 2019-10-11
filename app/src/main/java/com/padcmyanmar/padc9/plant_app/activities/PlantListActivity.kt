package com.padcmyanmar.padc9.plant_app.activities

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.TextView
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
        input_search.setOnEditorActionListener(TextView.OnEditorActionListener{ v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH){
                val search_keyword = input_search.text.toString()
                return@OnEditorActionListener true
            }
            false
        })

        input_search.setOnKeyListener{y,keyCode,event ->
            if(keyCode == KeyEvent.KEYCODE_DEL){
                mPresenter.onUiReady(this)
            }
            false
        }

        input_search.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                searchByName(p0.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

        })
    }

    fun searchByName(keywork:String){
        mAdapter.setNewData(plantModel.getPlantsByName(keywork) as MutableList<PlantVO>)
        rv_recycler.setAdapter(mAdapter)
    }

}