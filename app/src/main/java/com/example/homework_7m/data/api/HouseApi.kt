package com.example.homework_7m.data.api

import com.example.homework_7m.data.dtos.CamerasDto
import com.example.homework_7m.data.dtos.DoorsDto
import retrofit2.Response
import retrofit2.http.GET

interface HouseApi {

    @GET("cameras/")
    suspend fun getCamera(): Response<CamerasDto>

    @GET("doors/")
    suspend fun getDoor(): Response<DoorsDto>

}