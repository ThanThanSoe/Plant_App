package com.padcmyanmar.padc9.plant_app

import android.app.Application
import com.padcmyanmar.padc9.plant_app.data.models.PlantModelImp

class PlantApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        PlantModelImp.initDatabase(this)
    }

}