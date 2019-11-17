package com.padcmyanmar.padc9.plant_app.activities

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.transition.Fade
import android.transition.Slide
import android.util.DisplayMetrics
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationSet
import android.view.animation.OvershootInterpolator
import androidx.core.app.ActivityOptionsCompat
import androidx.transition.Visibility
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
        startActivity(Intent(applicationContext, PlantListActivity::class.java),
            ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle())
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
        //setUpTransaction()
        exitTransition()
        setContentView(R.layout.activity_main)

        mPresenter = LoginPresenter()
        mPresenter.init(this)


        btn_login.setOnClickListener(View.OnClickListener {
            mPresenter.loginAction(
                input_email.text.toString(),
                input_password.text.toString()
            )
        })

        setupFadeTransition()
    }

    private fun setupFadeTransition(){
        loginTxt_layout.visibility = View.VISIBLE

        val animator = ObjectAnimator.ofFloat(loginTxt_layout, View.ALPHA,0f, 1f)
        animator.addListener(object :AnimatorListenerAdapter(){
            override fun onAnimationEnd(animation: Animator?) {
                setUpSlideTransition()
            }
        })
        animator.interpolator= AccelerateDecelerateInterpolator()
        animator.duration = 2000L
        animator.start()
    }

    private fun setUpSlideTransition(){
        user_layout.visibility = View.VISIBLE
        val animator = ObjectAnimator.ofFloat(user_layout,View.TRANSLATION_X,600f, user_layout.width.toFloat())
        animator.addListener(object : AnimatorListenerAdapter(){
            override fun onAnimationEnd(animation: Animator?) {
                setUpBtnTransition()
            }
        })
        animator.interpolator = OvershootInterpolator()
        animator.duration = 2000
        animator.start()
    }

    private fun setUpBtnTransition(){
        btn_login.visibility = View.VISIBLE
        val animator = ObjectAnimator.ofFloat(btn_login, View.TRANSLATION_X, -600f, btn_login.width.toFloat())
        animator.interpolator = OvershootInterpolator()
        animator.duration= 2000
        animator.start()


    }
    private fun exitTransition(){
        /* with(window){
             requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
             val fadeTransition = Fade()
             fadeTransition.duration = 1000
             fadeTransition.interpolator = AccelerateDecelerateInterpolator()
             exitTransition = fadeTransition
         }*/
    }



}