package com.padcmyanmar.padc9.plant_app.persistense.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcmyanmar.padc9.plant_app.data.vos.PlantVO

@Dao
abstract class PlantListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertPlants(plants: List<PlantVO>): LongArray

    @Query("SELECT * FROM plants")
    abstract fun getAllPlants(): LiveData<List<PlantVO>>

    @Query("SELECT * FROM plants WHERE id=:id")
    abstract fun getFindById(id: Int): LiveData<PlantVO>

    @Query("SELECT * FROM plants")
    abstract fun getPlants(): List<PlantVO>

   /* fun arePlantExitInDB():Boolean{
        return getAllPlants().isNotEmpty()
    }*/

}
