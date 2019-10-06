package com.padcmyanmar.padc9.plant_app.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.padcmyanmar.padc9.plant_app.R
import com.padcmyanmar.padc9.plant_app.data.vos.LoginVO
import com.padcmyanmar.padc9.plant_app.mvp.presenters.LoginPresenter
import com.padcmyanmar.padc9.plant_app.mvp.views.LoginView
import com.padcmyanmar.padc9.plant_app.utils.GET_PREFERENCE
import com.padcmyanmar.padc9.plant_app.utils.SHARE_PREFERENCE

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login.*

class MainActivity : BaseActivity(), LoginView {

    lateinit var sharedPreferences: SharedPreferences
    override fun loginSuccess(user: List<LoginVO>) {
        startActivity(Intent(applicationContext, PlantListActivity::class.java))
        sharedPreferences = this.getSharedPreferences(SHARE_PREFERENCE, Context.MODE_PRIVATE)
        val editor =sharedPreferences.edit()
        editor.putInt(GET_PREFERENCE,1)
        editor.apply()
    }
    override fun loginFail(errorMessage: String) {
    }
    private lateinit var mPresenter: LoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPresenter = LoginPresenter()
        mPresenter.init(this)


        btn_login.setOnClickListener(View.OnClickListener {
            mPresenter.loginAction(
                input_email.text.toString(),
                input_password.text.toString()
            )
        })
    }

}