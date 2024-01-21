package com.example.homework_7m.domain.usecases.cameras


import com.example.homework_7m.domain.models.CameraModel
import com.example.homework_7m.domain.repositories.CamerasRepository
import javax.inject.Inject

class UpdateCameraUseCase @Inject constructor(
    private val cameraRepository: CamerasRepository
) {
    fun updateCamera(cameraModel: CameraModel) = cameraRepository.updateCamera(cameraModel)
}