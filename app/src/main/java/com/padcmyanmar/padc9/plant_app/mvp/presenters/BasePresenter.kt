package com.padcmyanmar.padc9.plant_app.mvp.presenters

import androidx.lifecycle.ViewModel
import com.padcmyanmar.padc9.plant_app.mvp.views.BaseView

abstract class BasePresenter<T: BaseView> :ViewModel(){
    protected lateinit var mView: T
    open fun init(view: T) {
        this.mView = view
    }

}