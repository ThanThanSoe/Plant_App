package com.padcmyanmar.padc9.plant_app.mvp.presenters

import androidx.lifecycle.Observer
import com.padcmyanmar.padc9.plant_app.activities.BaseActivity
import com.padcmyanmar.padc9.plant_app.data.models.PlantModelImp
import com.padcmyanmar.padc9.plant_app.mvp.views.DetailView

class DetailPresenter:BasePresenter<DetailView>() {

    fun onUIReady(plantId: Int,activity:BaseActivity){
        if(plantId !=0){
            val model = PlantModelImp
            val plantModel =model.getFindById(plantId)
                .observe(activity, Observer {
                    mView.displayPlantDetail(it)
                })

        }
    }
}