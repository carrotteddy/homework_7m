package com.example.homework_7m.domain.usecases.doors

import com.example.homework_7m.domain.DoorModel
import com.example.homework_7m.domain.repositories.DoorsRepository
import com.example.homework_7m.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RefreshDoorsUseCase @Inject constructor(
    private val doorRepository: DoorsRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<DoorModel>>> {

        doorRepository.getRemoteDoors().collect { resource ->
            if (resource is Resource.Success) {
                if (doorRepository.getLocalDoors().isEmpty()) {
                    doorRepository.insertLocalDoors(resource.data!!)
                } else {
                    doorRepository.updateLocalDoors(resource.data!!)
                }
            }
        }
        return doorRepository.getRemoteDoors()
    }

}