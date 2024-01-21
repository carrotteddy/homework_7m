package com.example.homework_7m.domain.usecases.cameras


import com.example.homework_7m.domain.models.CameraModel
import com.example.homework_7m.domain.repositories.CamerasRepository
import com.example.homework_7m.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class RefreshCamerasUseCase @Inject constructor(
    private val cameraRepository: CamerasRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<CameraModel>>> {

        cameraRepository.getRemoteCameras().collect { resource ->
            if (resource is Resource.Success) {
                if (cameraRepository.getLocalCameras().isEmpty()) {
                    cameraRepository.insertLocalCameras(resource.data!!)
                } else {
                    cameraRepository.updateLocalCameras(resource.data!!)
                }
            }
        }
        return cameraRepository.getRemoteCameras()
    }

}