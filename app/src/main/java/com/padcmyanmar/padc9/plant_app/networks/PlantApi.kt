package com.padcmyanmar.padc9.plant_app.networks

import com.padcmyanmar.padc9.plant_app.networks.response.PlantResponse
import com.padcmyanmar.padc9.plant_app.networks.response.UserLoginResponse
import com.padcmyanmar.padc9.plant_app.utils.GET_PLANTS
import com.padcmyanmar.padc9.plant_app.utils.LOGIN
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface PlantApi {

    @POST(GET_PLANTS)
    fun getAllPlants():retrofit2.Call<PlantResponse>

    @POST(LOGIN)
    @FormUrlEncoded
    fun setUserLogin(@Field("email") email:String, @Field("password")password:String): Call<UserLoginResponse>
}