package com.example.homework_7m.domain.usecases.doors

import com.example.homework_7m.domain.models.DoorModel
import com.example.homework_7m.domain.repositories.DoorsRepository
import com.example.homework_7m.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllDoorsUseCase @Inject constructor(
    private val doorRepository: DoorsRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<DoorModel>>> {
        val data = doorRepository.getLocalDoors()
        if (data.isEmpty()) {
            doorRepository.getRemoteDoors().collect {
                if (it is Resource.Success) {
                    doorRepository.insertLocalDoors(it.data!!)
                }
            }
            return doorRepository.getRemoteDoors()
        } else {
            return flow {
                emit(Resource.Success(data = data))
            }
        }
    }

}