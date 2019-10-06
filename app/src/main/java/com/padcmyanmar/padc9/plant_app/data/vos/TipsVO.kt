package com.padcmyanmar.padc9.plant_app.data.vos

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class TipsVO(
    @ColumnInfo(name = "temperature")
    @SerializedName("temperature")
    val temperature: String,
    @ColumnInfo(name = "light")
    @SerializedName("light")
    val light :String,
    @ColumnInfo(name = "placement")
    @SerializedName("placement")
    val placement: String

)