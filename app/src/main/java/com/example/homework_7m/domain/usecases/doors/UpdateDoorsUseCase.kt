package com.example.homework_7m.domain.usecases.doors

import com.example.homework_7m.domain.DoorModel
import com.example.homework_7m.domain.repositories.DoorsRepository
import javax.inject.Inject

class UpdateDoorUseCase @Inject constructor(
    private val doorRepository: DoorsRepository
) {
    fun updateDoor(doorModel: DoorModel) = doorRepository.updateDoor(doorModel)
}