package com.padcmyanmar.padc9.plant_app.data.models

import androidx.lifecycle.LiveData
import com.padcmyanmar.padc9.plant_app.data.vos.LoginVO
import com.padcmyanmar.padc9.plant_app.data.vos.PlantVO

interface PlantModel {
    fun getPlants(onFailure: (String)-> Unit):LiveData<List<PlantVO>>
    fun loginUser(
        onSuccess: (List<LoginVO>)-> Unit,
        onFailure: (String) -> Unit
    )
    fun getFindById(id: Int) :LiveData<PlantVO>

    fun getPlantsByName(plant_name:String):List<PlantVO>
}