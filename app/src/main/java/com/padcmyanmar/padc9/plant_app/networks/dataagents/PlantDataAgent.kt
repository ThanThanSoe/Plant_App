package com.padcmyanmar.padc9.plant_app.networks.dataagents

import com.padcmyanmar.padc9.plant_app.data.vos.LoginVO
import com.padcmyanmar.padc9.plant_app.data.vos.PlantVO

interface PlantDataAgent {
    fun getPlants(
        onSuccess: (List<PlantVO> )-> Unit,
        onFailure:(String)-> Unit
    )
    fun setLogin(
        onSuccess: (List<LoginVO>) -> Unit,
        onFailure: (String) -> Unit
    )
}