package com.example.homework_7m.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.homework_7m.data.dtos.CameraDto
import com.example.homework_7m.data.dtos.CamerasDto
import com.example.homework_7m.data.dtos.DoorDto

@Database(entities = [CameraDto::class, DoorDto::class], version = 1, exportSchema = true)
abstract class HouseDatabase: RoomDatabase() {

    abstract fun getCameraDao(): CameraDao
    abstract fun getDoorDao(): DoorDao

}