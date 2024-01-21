package com.example.homework_7m.domain.usecases.cameras


import com.example.homework_7m.domain.models.CameraModel
import com.example.homework_7m.domain.repositories.CamerasRepository
import javax.inject.Inject

class DeleteCameraUseCase @Inject constructor(
    private val cameraRepository: CamerasRepository
) {
    fun deleteCamera(cameraModel: CameraModel) = cameraRepository.deleteCamera(cameraModel)
}