package com.padcmyanmar.padc9.plant_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.padc9.plant_app.R
import com.padcmyanmar.padc9.plant_app.data.vos.PlantVO
import com.padcmyanmar.padc9.plant_app.delegate.PlantDelegate
import com.padcmyanmar.padc9.plant_app.views.holders.PlantListViewHolder

class PlantListAdapter(private val delegate: PlantDelegate):BaseAdapter<PlantListViewHolder, PlantVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_list,parent,false)
        return PlantListViewHolder(view,delegate)
    }
}