package com.padcmyanmar.padc9.plant_app.networks.dataagents

import com.padcmyanmar.padc9.plant_app.data.vos.LoginVO
import com.padcmyanmar.padc9.plant_app.data.vos.PlantVO
import com.padcmyanmar.padc9.plant_app.networks.PlantApi
import com.padcmyanmar.padc9.plant_app.networks.response.PlantResponse
import com.padcmyanmar.padc9.plant_app.networks.response.UserLoginResponse
import com.padcmyanmar.padc9.plant_app.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitDataAgentImp : PlantDataAgent {


    private val plantApi: PlantApi

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        plantApi = retrofit.create(PlantApi::class.java)
    }

    override fun getPlants(onSuccess: (List<PlantVO>) -> Unit, onFailure:(String)-> Unit) {
        val call = plantApi.getAllPlants()
        call.enqueue(object : Callback<PlantResponse> {
            override fun onResponse(call: Call<PlantResponse>, response: Response<PlantResponse>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null)
                        if (responseBody.data != null) {
                            onSuccess(responseBody.data)
                        } else {
                            onFailure(response.message())
                        }
                }
            }

            override fun onFailure(call: Call<PlantResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }
        })

    }

    override fun setLogin(onSuccess: (List<LoginVO>) -> Unit, onFailure: (String) -> Unit) {
        val call = plantApi.setUserLogin(String(), String())
        call.enqueue(object : Callback<UserLoginResponse> {
            override fun onResponse(
                call: Call<UserLoginResponse>,
                response: Response<UserLoginResponse>
            ) {
                if (response.isSuccessful){
                    val responseBody =response.body()
                    if (responseBody!=null)
                    {
                        if (responseBody.data!= null)
                        {
                            onSuccess(listOf(responseBody.data))

                        }else{
                            onFailure(response.message())
                        }
                    }
                }
            }

            override fun onFailure(call: Call<UserLoginResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }
        })
    }

}