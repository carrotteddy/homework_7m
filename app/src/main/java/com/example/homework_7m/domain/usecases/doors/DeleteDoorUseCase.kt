package com.example.homework_7m.domain.usecases.doors

import com.example.homework_7m.domain.models.DoorModel
import com.example.homework_7m.domain.repositories.DoorsRepository
import javax.inject.Inject

class DeleteDoorUseCase @Inject constructor(
    private val doorRepository: DoorsRepository
) {
    fun deleteDoor(doorModel: DoorModel) = doorRepository.deleteDoor(doorModel)
}