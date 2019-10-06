package com.padcmyanmar.padc9.plant_app.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.padcmyanmar.padc9.plant_app.data.models.PlantModel
import com.padcmyanmar.padc9.plant_app.data.models.PlantModelImp

abstract class BaseActivity : AppCompatActivity() {
    protected lateinit var plantModel: PlantModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        plantModel = PlantModelImp
    }
}