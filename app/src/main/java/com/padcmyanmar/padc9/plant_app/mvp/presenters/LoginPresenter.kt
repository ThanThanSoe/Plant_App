package com.padcmyanmar.padc9.plant_app.mvp.presenters

import android.content.SharedPreferences
import com.padcmyanmar.padc9.plant_app.data.models.PlantModelImp
import com.padcmyanmar.padc9.plant_app.delegate.PlantDelegate
import com.padcmyanmar.padc9.plant_app.mvp.views.LoginView

class LoginPresenter : BasePresenter<LoginView>(), PlantDelegate {
    private val model = PlantModelImp
    private lateinit var sharedPreferences: SharedPreferences

    override fun loginAction(email: String, password: String) {

        model.loginUser(
            { login ->
                mView.loginSuccess(login)
            },
            {
                mView.loginFail(it)
            }
        )

    }

    override fun onTapPlantItem(id: Int) {

    }

}