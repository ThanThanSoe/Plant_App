package com.padcmyanmar.padc9.plant_app.networks.response

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.padc9.plant_app.data.vos.LoginVO
import com.padcmyanmar.padc9.plant_app.utils.CODE_RESPONSE_OK

data class UserLoginResponse (
    @SerializedName("message")
    val message: String,
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val data: LoginVO
){
    fun isLoginOK():Boolean{
        return code == CODE_RESPONSE_OK && data != null
    }
}