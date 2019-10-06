package com.padcmyanmar.padc9.plant_app.persistense.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcmyanmar.padc9.plant_app.data.vos.LoginVO

@Dao
abstract class UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertUser(user: List<LoginVO>)

    @Query("SELECT * FROM user")
    abstract fun getUser(): List<LoginVO>

    fun isUserExit(): Boolean{
        return getUser().isNotEmpty()
    }
}