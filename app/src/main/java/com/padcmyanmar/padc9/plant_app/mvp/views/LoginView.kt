package com.padcmyanmar.padc9.plant_app.mvp.views

import com.padcmyanmar.padc9.plant_app.data.vos.LoginVO

interface LoginView:BaseView {
    fun loginSuccess(user: List<LoginVO>)
    fun loginFail(errorMessage: String)
}