package com.padcmyanmar.padc9.plant_app.data.vos

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class UploadUserVO(
    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name: String,
    @ColumnInfo(name = "user_photo")
    @SerializedName("user_photo")
    val userPhoto: String,
    @ColumnInfo(name = "uploaded_time")
    @SerializedName("uploaded_time")
    val uploadedTime: String,
    @ColumnInfo(name = "user_rank")
    @SerializedName("user_rank")
    val userRank: String

)