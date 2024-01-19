package com.example.homework_7m.domain.usecases.cameras

import com.example.homework_7m.domain.CameraModel
import com.example.homework_7m.domain.repositories.CamerasRepository
import com.example.homework_7m.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllCamerasUseCase @Inject constructor(
    private val cameraRepository: CamerasRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<CameraModel>>> {
        val data = cameraRepository.getLocalCameras()
        if (data.isEmpty()) {
            cameraRepository.getRemoteCameras().collect {
                if (it is Resource.Success) {
                    cameraRepository.insertLocalCameras(it.data!!)
                }
            }
            return cameraRepository.getRemoteCameras()
        } else {
            return flow {
                emit(Resource.Success(data = data))
            }
        }
    }

}