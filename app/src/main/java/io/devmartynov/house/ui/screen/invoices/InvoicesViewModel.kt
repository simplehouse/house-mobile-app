package io.devmartynov.house.ui.screen.invoices

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.devmartynov.house.app.model.ActionStatus
import io.devmartynov.house.app.model.Result
import io.devmartynov.house.domain.useCase.GetInvoicesUseCase
import io.devmartynov.house.ui.screen.invoices.model.InvoicesEvent
import io.devmartynov.house.ui.screen.invoices.model.InvoicesState
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

/**
 * Вью модель экрана списка квитанций
 */
@HiltViewModel
class InvoicesViewModel @Inject constructor(
    private val getInvoicesUseCase: GetInvoicesUseCase,
) : ViewModel() {
    val uiState = MutableStateFlow(InvoicesState())

    init {
        loadInvoicesData(isInitialRequest = true)
    }

    /**
     * Обработка событий на экране квитанций
     *
     * @param event событие на экране квитанций
     * @see InvoicesEvent
     */
    fun handleEvent(event: InvoicesEvent) {
        when (event) {
            is InvoicesEvent.DataRefreshed -> {
                loadInvoicesData()
            }
        }
    }

    /**
     * Загружает список квитанций
     *
     * @param isInitialRequest первая загрузка или обновление
     */
    private fun loadInvoicesData(isInitialRequest: Boolean = false) {
        uiState.value = uiState.value.copy(
            invoicesStatus = if (isInitialRequest) {
                ActionStatus.Loading
            } else {
                ActionStatus.Refreshing
            }
        )

        viewModelScope.launch(Dispatchers.IO) {
            val result = getInvoicesUseCase()

            withContext(Dispatchers.Main) {
                when (result) {
                    is Result.Success -> {
                        uiState.value = uiState.value.copy(
                            invoices = result.value,
                            invoicesStatus = ActionStatus.Success,
                        )
                    }
                    is Result.Failure -> {
                        // todo show notification
                    }
                }
            }
        }
    }
}