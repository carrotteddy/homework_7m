package com.example.homework_7m.domain.repositories

import com.example.homework_7m.domain.models.DoorModel
import com.example.homework_7m.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface DoorsRepository {

    suspend fun getRemoteDoors(): Flow<Resource<List<DoorModel>>>

    fun getLocalDoors(): List<DoorModel>

    fun insertDoor(doorModel: DoorModel)

    fun insertLocalDoors(doorModels: List<DoorModel>)

    fun updateDoor(doorModel: DoorModel)

    fun updateLocalDoors(doorModels: List<DoorModel>)

    fun deleteDoor(doorModel: DoorModel)

}