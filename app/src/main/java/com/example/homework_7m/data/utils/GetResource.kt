package com.example.homework_7m.data.utils

import com.example.homework_7m.data.utils.Constants.CONNECTION_ERROR
import com.example.homework_7m.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class GetResource {
    protected suspend fun <T> getResult(result: suspend () -> T) = flow {
        emit(Resource.Loading())
        try {
            val data = result()
            emit(Resource.Success(data))
        } catch (exception: Exception) {
            emit(Resource.Error(message = exception.message ?: CONNECTION_ERROR))
        }
    }.flowOn(Dispatchers.IO)

}