package com.example.homework_7m.domain

data class CameraModel(
    val id: Long,
    val favorites: Boolean,
    val name: String,
    val rec: Boolean,
    val room: String,
    val image: String
)