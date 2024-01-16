package com.example.homework_7m.app

import android.app.Application
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent

@HiltAndroidApp
@InstallIn(SingletonComponent::class)
class App : Application() {
}