package com.example.homework_7m.presentation.ui.fragments.cameras

import androidx.lifecycle.viewModelScope
import com.example.homework_7m.data.local.db.CameraDao
import com.example.homework_7m.domain.models.CameraModel
import com.example.homework_7m.domain.usecases.cameras.DeleteCameraUseCase
import com.example.homework_7m.domain.usecases.cameras.GetAllCamerasUseCase
import com.example.homework_7m.domain.usecases.cameras.InsertCameraUseCase
import com.example.homework_7m.domain.usecases.cameras.RefreshCamerasUseCase
import com.example.homework_7m.domain.usecases.cameras.UpdateCameraUseCase
import com.example.homework_7m.domain.utils.Resource
import com.example.homework_7m.presentation.base.BaseViewModel
import com.example.homework_7m.presentation.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CamerasViewModel @Inject constructor(
    private val getAllCamerasUseCase: GetAllCamerasUseCase,
    private val refreshCamerasUseCase: RefreshCamerasUseCase,
    private val insertCameraUseCase: InsertCameraUseCase,
    private val updateCameraUseCase: UpdateCameraUseCase,
    private val deleteCameraUseCase: DeleteCameraUseCase
) : BaseViewModel() {

    private val _camerasList = MutableStateFlow<UiState<List<CameraModel>>>(UiState.Loading())
    val camerasList: StateFlow<UiState<List<CameraModel>>> = _camerasList

    fun getAllCameras() = doRequest {
        getAllCamerasUseCase()
    }

    fun refreshCameras() = doRequest {
        refreshCamerasUseCase()
    }

    private fun doRequest(useCase: suspend () -> Flow<Resource<List<CameraModel>>>) {
        viewModelScope.launch(Dispatchers.IO) {
            _camerasList.value = collectData { useCase() }
        }
    }

    fun onCamerasSwiped(camera: Int) = viewModelScope.launch {
        CameraDao.delete(camera)
    }

}