package com.padcmyanmar.padc9.plant_app.persistense

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.padcmyanmar.padc9.plant_app.data.vos.LoginVO
import com.padcmyanmar.padc9.plant_app.data.vos.PlantVO
import com.padcmyanmar.padc9.plant_app.persistense.dao.PlantListDao
import com.padcmyanmar.padc9.plant_app.persistense.dao.UserDao
import com.padcmyanmar.padc9.plant_app.utils.PLANT_DB

@Database(entities = arrayOf(PlantVO::class, LoginVO::class), version = 7, exportSchema = false)
abstract class PlantDatabase : RoomDatabase() {
    abstract fun plantDao(): PlantListDao
    abstract fun userDao(): UserDao

    companion object {
        private var instance: PlantDatabase? = null

        fun getInstance(context: Context): PlantDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context, PlantDatabase::class.java, PLANT_DB)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            val db = instance!!
            return db
        }
    }
}
