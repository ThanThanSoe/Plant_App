package com.padcmyanmar.padc9.plant_app.networks.response

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.padc9.plant_app.data.vos.PlantVO
import com.padcmyanmar.padc9.plant_app.utils.CODE_RESPONSE_OK

data class PlantResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val data: List<PlantVO>
){
    fun isResponseOK():Boolean{
        return code == CODE_RESPONSE_OK && data != null
    }
}