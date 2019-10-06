package com.padcmyanmar.padc9.plant_app.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user")
data class LoginVO (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "user_id")
    @SerializedName("user_id")
    val userId: String,
    @ColumnInfo(name = "user_name")
    @SerializedName("user_name")
    val userName:String,
    @ColumnInfo(name = "user_photo_url")
    @SerializedName("user_photo_url")
    val userPhotoUrl: String,
    @ColumnInfo(name = "member_scince")
    @SerializedName("member_scince")
    val member:String,
    @ColumnInfo(name = "member_rank")
    @SerializedName("member_rank")
    val memberRank: String
)