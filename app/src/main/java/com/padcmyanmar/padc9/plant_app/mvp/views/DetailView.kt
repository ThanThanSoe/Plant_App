package com.padcmyanmar.padc9.plant_app.mvp.views

import com.padcmyanmar.padc9.plant_app.data.vos.PlantVO

interface DetailView:BaseView {
    fun displayPlantDetail(plantVO: PlantVO)
}