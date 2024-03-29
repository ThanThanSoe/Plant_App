package com.padcmyanmar.padc9.plant_app.data.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.padcmyanmar.padc9.plant_app.data.vos.LoginVO
import com.padcmyanmar.padc9.plant_app.data.vos.PlantVO

object PlantModelImp : BaseModel(), PlantModel {
    override fun loginUser(onSuccess: (List<LoginVO>) -> Unit, onFailure: (String) -> Unit) {
        val userFromDB = database.userDao().getUser()
        if (userFromDB.isNotEmpty()){
            onSuccess(userFromDB)
        }else{
            dataAgent.setLogin(
                {
                    onSuccess(it)
                },
                {
                    onFailure(it)
                }
            )
        }
    }

    override fun getPlants(onFailure: (String) -> Unit):LiveData<List<PlantVO>> {
        val plantFromDB = database.plantDao().getAllPlants()
            dataAgent.getPlants(
                {
                    database.plantDao().insertPlants(it)
                },
                onFailure
            )
        return plantFromDB
    }

    override fun getFindById(id: Int): LiveData<PlantVO> {
        //return Transformations.distinctUni
        return Transformations.distinctUntilChanged(
            database.plantDao().getFindById(id)
        )
    }

    override fun getPlantsByName(plant_name: String): List<PlantVO> {
        val plantVO = database.plantDao().getPlants()
        val serach_plant = ArrayList<PlantVO>()
        for (plants in plantVO){
            if(plants.plantName.toLowerCase().contains(plant_name.toLowerCase())){
                serach_plant.add(plants)
            }
        }
        return serach_plant
    }
}