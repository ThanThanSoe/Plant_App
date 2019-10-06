package com.padcmyanmar.padc9.plant_app.mvp.presenters

import androidx.lifecycle.Observer
import com.padcmyanmar.padc9.plant_app.activities.BaseActivity
import com.padcmyanmar.padc9.plant_app.data.models.PlantModelImp
import com.padcmyanmar.padc9.plant_app.delegate.PlantDelegate
import com.padcmyanmar.padc9.plant_app.mvp.views.PlantListView

class PlantListPresenter : BasePresenter<PlantListView>(), PlantDelegate {
    override fun loginAction(email: String, password: String) {

    }

    override fun onTapPlantItem(id: Int) {
        mView.navigateToNavigate(id)
    }


    fun onUiReady(activity: BaseActivity){
        val model = PlantModelImp
        model.getPlants{mView.displayError(it)}
            .observe(activity, Observer {
                mView.displayPlantList(it)
            })
    }
}