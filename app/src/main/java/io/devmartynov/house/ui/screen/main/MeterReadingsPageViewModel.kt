package io.devmartynov.house.ui.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.devmartynov.house.domain.model.MeterReading
import io.devmartynov.house.domain.model.Service
import io.devmartynov.house.domain.useCase.LoadMeterReadingsUseCase
import io.devmartynov.house.ui.screen.main.model.MeterReadingsPageEvent
import io.devmartynov.house.ui.screen.main.model.MeterReadingsPageState
import io.devmartynov.house.ui.shared.model.ActionStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Вью модель страницы списка показаний счетчика(страница в HorizontalPager)
 */
@HiltViewModel
class MeterReadingsPageViewModel @Inject constructor(
    private val loadMeterReadingsUseCase: LoadMeterReadingsUseCase,
) : ViewModel() {
    val uiState = MutableStateFlow(MeterReadingsPageState())

    init {
        loadMeterReadings(isInitialRequest = true)
    }

    /**
     * Обработка события на странице списка показаний счетчика
     * @param event событие на экране
     */
    fun handleEvent(event: MeterReadingsPageEvent) {
        when (event) {
            is MeterReadingsPageEvent.DataRefreshed -> {
                loadMeterReadings()
            }
        }
    }

    /**
     * Получает список показаний счетчиков
     *
     * @param isInitialRequest начальная загрузка или нет
     */
    private fun loadMeterReadings(isInitialRequest: Boolean = false) {
        uiState.value = uiState.value.copy(
            status = if (isInitialRequest) {
                ActionStatus.Loading
            } else {
                ActionStatus.Refreshing
            }
        )

        viewModelScope.launch(Dispatchers.IO) {
            loadMeterReadingsUseCase(Service.GAS)
            delay(2000L)

            withContext(Dispatchers.Main) {
                uiState.value = uiState.value.copy(
                    status = ActionStatus.Success,
                    meterReadings = metaReadings
                )
            }
        }
    }
}

val metaReadings = listOf(
    MeterReading(
        id = 1,
        createDate = "11.12.12",
        isExpired = false,
        toPayAmount = 133,
        service = Service.GAS,
        diffWithPrevValue = 0.3f,
        value = 00033312f,
        usageAmount = 0.3f,
    ),
    MeterReading(
        id = 2,
        createDate = "11.12.12",
        isExpired = false,
        toPayAmount = 133,
        service = Service.GAS,
        diffWithPrevValue = 0.3f,
        value = 00033312f,
        usageAmount = 0.3f,
    ),
    MeterReading(
        id = 3,
        createDate = "11.12.12",
        isExpired = false,
        toPayAmount = 133,
        service = Service.GAS,
        diffWithPrevValue = 0.3f,
        value = 00033312f,
        usageAmount = 0.3f,
    ),
    MeterReading(
        id = 4,
        createDate = "11.12.12",
        isExpired = false,
        toPayAmount = 133,
        service = Service.GAS,
        diffWithPrevValue = 0.3f,
        value = 00033312f,
        usageAmount = 0.3f,
    ),
    MeterReading(
        id = 5,
        createDate = "11.12.12",
        isExpired = false,
        toPayAmount = 133,
        service = Service.GAS,
        diffWithPrevValue = 0.3f,
        value = 00033312f,
        usageAmount = 0.3f,
    ),
    MeterReading(
        id = 6,
        createDate = "11.12.12",
        isExpired = false,
        toPayAmount = 133,
        service = Service.GAS,
        diffWithPrevValue = 0.3f,
        value = 00033312f,
        usageAmount = 0.3f,
    ),
    MeterReading(
        id = 7,
        createDate = "11.12.12",
        isExpired = false,
        toPayAmount = 133,
        service = Service.GAS,
        diffWithPrevValue = 0.3f,
        value = 00033312f,
        usageAmount = 0.3f,
    ),
    MeterReading(
        id = 8,
        createDate = "11.12.12",
        isExpired = false,
        toPayAmount = 133,
        service = Service.GAS,
        diffWithPrevValue = 0.3f,
        value = 00033312f,
        usageAmount = 0.3f,
    ),
    MeterReading(
        id = 9,
        createDate = "11.12.12",
        isExpired = false,
        toPayAmount = 133,
        service = Service.GAS,
        diffWithPrevValue = 0.3f,
        value = 00033312f,
        usageAmount = 0.3f,
    ),
    MeterReading(
        id = 10,
        createDate = "11.12.12",
        isExpired = false,
        toPayAmount = 133,
        service = Service.GAS,
        diffWithPrevValue = 0.3f,
        value = 00033312f,
        usageAmount = 0.3f,
    ),
    MeterReading(
        id = 11,
        createDate = "11.12.12",
        isExpired = false,
        toPayAmount = 133,
        service = Service.GAS,
        diffWithPrevValue = 0.3f,
        value = 00033312f,
        usageAmount = 0.3f,
    ),
    MeterReading(
        id = 12,
        createDate = "11.12.12",
        isExpired = false,
        toPayAmount = 133,
        service = Service.GAS,
        diffWithPrevValue = 0.3f,
        value = 00033312f,
        usageAmount = 0.3f,
    ),
)