package com.padcmyanmar.padc9.plant_app.data.vos

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "plants")
data class PlantVO (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "plant_id")
    @SerializedName("plant_id")
    val plantId: String,

    @ColumnInfo(name = "plant_name")
    @SerializedName("plant_name")
    val plantName: String,

    @ColumnInfo(name = "description")
    @SerializedName("description")
    val description: String,

    @SerializedName("uploaded_user")
    @Embedded(prefix = "uploaded_user")
    val uploadUser: UploadUserVO,

    @ColumnInfo(name = "plant_photo")
    @SerializedName("plant_photo")
    val plantPhoto: String
)
