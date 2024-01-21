package com.example.homework_7m.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.homework_7m.data.dtos.DoorDto

@Dao
interface DoorDao {

    @Query("SELECT * FROM door_table")
    fun getAllDoors(): List<DoorDto>

    @Insert
    fun insertDoor(door: DoorDto)

    @Insert
    fun insertAllDoors(doors: List<DoorDto>)

    @Update
    fun updateAllDoors(doors: List<DoorDto>)

    @Update
    fun updateDoor(door: DoorDto)

    @Delete
    fun deleteDoor(door: DoorDto)

    companion object {
        fun delete(doors: Int) {
            DoorDao.delete(doors)
        }
    }

}