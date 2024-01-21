package com.example.homework_7m.domain.repositories

import com.example.homework_7m.domain.models.CameraModel
import com.example.homework_7m.domain.utils.Resource
import kotlinx.coroutines.flow.Flow


interface CamerasRepository {

    suspend fun getRemoteCameras(): Flow<Resource<List<CameraModel>>>

    fun getLocalCameras(): List<CameraModel>

    fun insertCamera(cameraModel: CameraModel)

    fun insertLocalCameras(cameraModels: List<CameraModel>)

    fun updateCamera(cameraModel: CameraModel)

    fun updateLocalCameras(cameraModels: List<CameraModel>)

    fun deleteCamera(cameraModel: CameraModel)

}