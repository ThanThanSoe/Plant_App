package com.padcmyanmar.padc9.plant_app.data.models

import android.content.Context
import com.padcmyanmar.padc9.plant_app.networks.dataagents.PlantDataAgent
import com.padcmyanmar.padc9.plant_app.networks.dataagents.RetrofitDataAgentImp
import com.padcmyanmar.padc9.plant_app.persistense.PlantDatabase

open class BaseModel {
    protected var dataAgent: PlantDataAgent = RetrofitDataAgentImp
    protected lateinit var database: PlantDatabase

    fun initDatabase(context: Context){
        database = PlantDatabase.getInstance(context)
    }
}