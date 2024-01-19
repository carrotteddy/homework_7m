package com.example.homework_7m.domain.usecases.cameras

import com.example.homework_7m.domain.CameraModel
import com.example.homework_7m.domain.repositories.CamerasRepository
import javax.inject.Inject

class InsertCameraUseCase @Inject constructor(
    private val cameraRepository: CamerasRepository
) {
    fun insertCamera(cameraModel: CameraModel) = cameraRepository.insertCamera(cameraModel)
}