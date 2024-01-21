package com.example.homework_7m.di

import com.example.homework_7m.data.repositories.CameraRepositoriesImpl
import com.example.homework_7m.data.repositories.DoorRepositoriesImpl
import com.example.homework_7m.domain.repositories.CamerasRepository
import com.example.homework_7m.domain.repositories.DoorsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindCameraRepository(cameraRepositoryImpl: CameraRepositoriesImpl): CamerasRepository

    @Binds
    fun bindDoorRepository(doorRepositoryImpl: DoorRepositoriesImpl): DoorsRepository

}