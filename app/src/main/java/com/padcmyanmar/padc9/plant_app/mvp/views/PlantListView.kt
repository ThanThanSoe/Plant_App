package com.padcmyanmar.padc9.plant_app.mvp.views

import com.padcmyanmar.padc9.plant_app.data.vos.PlantVO

interface PlantListView: BaseView {
    fun displayPlantList(plantList: List<PlantVO>)
    fun displayError(errorMessage: String)
    fun navigateToNavigate(plantId: Int)
}