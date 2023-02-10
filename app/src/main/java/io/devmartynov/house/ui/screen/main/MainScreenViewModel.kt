package io.devmartynov.house.ui.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.devmartynov.house.domain.useCase.LoadServicesDatesUseCase
import io.devmartynov.house.ui.screen.main.model.MainScreenEvent
import io.devmartynov.house.ui.screen.main.model.MainScreenState
import io.devmartynov.house.ui.shared.model.ActionStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Вью модель главного экрана
 */
@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val loadServicesDatesUseCase: LoadServicesDatesUseCase,
) : ViewModel() {
    val uiState = MutableStateFlow(MainScreenState())

    init {
        loadServicesDates()
    }

    /**
     * Обработка события на главном экране
     * @param event событие на главном экране
     */
    fun handleEvent(event: MainScreenEvent) {
        when (event) {
            is MainScreenEvent.DataRefreshed -> {
                loadServicesDates()
            }
        }
    }

    /**
     * Получает даты подачи показаний
     *
     * @param isInitialRequest начальная загрузка или нет
     */
    private fun loadServicesDates(isInitialRequest: Boolean = false) {
        uiState.value = uiState.value.copy(
            status = if (isInitialRequest) {
                ActionStatus.Loading
            } else {
                ActionStatus.Refreshing
            }
        )

        viewModelScope.launch(Dispatchers.IO) {
            loadServicesDatesUseCase()
            delay(2000L)

            withContext(Dispatchers.Main) {
                uiState.value = uiState.value.copy(
                    status = ActionStatus.Success,
                    gasDate = "11.11.11",
                    waterDate = "12.12.12",
                    electricityDate = "13.10.13"
                )
            }
        }
    }
}