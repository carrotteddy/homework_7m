package com.example.homework_7m.di

import com.example.homework_7m.data.repositories.CameraRepositoriesImpl
import com.example.homework_7m.data.repositories.DoorRepositoriesImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindCameraRepository(cameraRepositoryImpl: CameraRepositoriesImpl): CameraRepositoriesImpl

    @Binds
    fun bindDoorRepository(doorRepositoryImpl: DoorRepositoriesImpl): DoorRepositoriesImpl

}