package com.example.homework_7m.data.repositories

import com.example.homework_7m.data.api.HouseApi
import com.example.homework_7m.data.dtos.toDataDto
import com.example.homework_7m.data.dtos.toDomainModel
import com.example.homework_7m.data.local.db.DoorDao
import com.example.homework_7m.domain.models.DoorModel
import com.example.homework_7m.domain.repositories.DoorsRepository
import com.example.homework_7m.data.utils.GetResource
import javax.inject.Inject

class DoorRepositoriesImpl @Inject constructor(
    private val dao: DoorDao,
    private val houseApi: HouseApi,
) : DoorsRepository, GetResource() {

    override suspend fun getRemoteDoors() = getResult {
        houseApi.getDoor().body()!!.data.toDomainModel()
    }

    override fun getLocalDoors(): List<DoorModel> {
        return dao.getAllDoors().toDomainModel()
    }

    override fun insertDoor(doorModel: DoorModel) {
        dao.insertDoor(doorModel.toDataDto())
    }

    override fun insertLocalDoors(doorModels: List<DoorModel>) {
        return dao.insertAllDoors(doorModels.toDataDto())
    }

    override fun updateDoor(doorModel: DoorModel) {
        dao.updateDoor(doorModel.toDataDto())
    }

    override fun updateLocalDoors(doorModels: List<DoorModel>) {
        dao.updateAllDoors(doorModels.toDataDto())
    }

    override fun deleteDoor(doorModel: DoorModel) {
        dao.deleteDoor(doorModel.toDataDto())
    }


}