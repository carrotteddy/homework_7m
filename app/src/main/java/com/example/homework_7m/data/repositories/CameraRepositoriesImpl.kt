package com.example.homework_7m.data.repositories

import com.example.homework_7m.data.api.HouseApi
import com.example.homework_7m.data.dtos.toDataDto
import com.example.homework_7m.data.dtos.toDomainModel
import com.example.homework_7m.data.local.db.CameraDao
import com.example.homework_7m.domain.CameraModel
import com.example.homework_7m.domain.repositories.CamerasRepository
import com.example.homework_7m.utils.GetResource
import javax.inject.Inject

class CameraRepositoriesImpl @Inject constructor(
    private val dao: CameraDao,
    private val houseApi: HouseApi,
) : CamerasRepository, GetResource() {

    override suspend fun getRemoteCameras() = getResult {
        houseApi.getCamera().body()!!.data.cameras.toDomainModel()
    }

    override fun getLocalCameras(): List<CameraModel> {
        return dao.getAllCameras().toDomainModel()
    }

    override fun insertCamera(cameraModel: CameraModel) {
        dao.insertCamera(cameraModel.toDataDto())
    }

    override fun insertLocalCameras(cameraModels: List<CameraModel>) {
        dao.insertAllCameras(cameraModels.toDataDto())
    }

    override fun updateCamera(cameraModel: CameraModel) {
        dao.updateCamera(cameraModel.toDataDto())
    }

    override fun updateLocalCameras(cameraModels: List<CameraModel>) {
        dao.updateAllCameras(cameraModels.toDataDto())
    }

    override fun deleteCamera(cameraModel: CameraModel) {
       dao.deleteCamera(cameraModel.toDataDto())
    }
}