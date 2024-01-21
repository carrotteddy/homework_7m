package com.example.homework_7m.presentation.ui.fragments.doors

import androidx.lifecycle.viewModelScope
import com.example.homework_7m.data.local.db.DoorDao
import com.example.homework_7m.domain.models.DoorModel
import com.example.homework_7m.domain.usecases.doors.DeleteDoorUseCase
import com.example.homework_7m.domain.usecases.doors.GetAllDoorsUseCase
import com.example.homework_7m.domain.usecases.doors.InsertDoorUseCase
import com.example.homework_7m.domain.usecases.doors.RefreshDoorsUseCase
import com.example.homework_7m.domain.usecases.doors.UpdateDoorUseCase
import com.example.homework_7m.domain.utils.Resource
import com.example.homework_7m.presentation.base.BaseViewModel
import com.example.homework_7m.presentation.utils.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class DoorsViewModel @Inject constructor(
    private val getAllDoorsUseCase: GetAllDoorsUseCase,
    private val refreshDoorsUseCase: RefreshDoorsUseCase,
    private val insertDoorUseCase: InsertDoorUseCase,
    private val updateDoorUseCase: UpdateDoorUseCase,
    private val deleteDoorUseCase: DeleteDoorUseCase
) : BaseViewModel() {

    private val _doorsList = MutableStateFlow<UiState<List<DoorModel>>>(UiState.Loading())
    val doorsList: StateFlow<UiState<List<DoorModel>>> = _doorsList

    fun getAllDoors() = doRequest {
        getAllDoorsUseCase()
    }

    fun refreshDoors() = doRequest {
        refreshDoorsUseCase()
    }

    private fun doRequest(useCase: suspend () -> Flow<Resource<List<DoorModel>>>) {
        viewModelScope.launch(Dispatchers.IO) {
            _doorsList.value = collectData { useCase() }
        }
    }

    fun onDoorsSwiped(doors: Int) = viewModelScope.launch {
        DoorDao.delete(doors)
    }

}