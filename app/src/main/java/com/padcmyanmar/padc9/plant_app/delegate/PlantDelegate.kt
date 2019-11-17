package com.padcmyanmar.padc9.plant_app.delegate

import android.widget.ImageView

interface PlantDelegate {
    fun onTapPlantItem(id:Int, tImageView: ImageView)

    fun loginAction(email: String,password: String)
}