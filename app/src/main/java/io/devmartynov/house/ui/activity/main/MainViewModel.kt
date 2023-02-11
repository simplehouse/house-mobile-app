package io.devmartynov.house.ui.activity.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.devmartynov.house.domain.model.Auth
import io.devmartynov.house.domain.model.AuthStateListener
import io.devmartynov.house.domain.useCase.GetUserUseCase
import io.devmartynov.house.domain.useCase.SetThemeUseCase
import io.devmartynov.house.ui.activity.main.model.MainEvent
import io.devmartynov.house.ui.activity.main.model.MainState
import io.devmartynov.house.ui.shared.model.ActionStatus
import io.devmartynov.house.ui.shared.model.Theme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import io.devmartynov.house.domain.model.Result

/**
 * Вью модель активити(в приложении только одна активити)
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val themeUseCase: SetThemeUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val auth: Auth,
) : ViewModel() {
    val uiState = MutableStateFlow(MainState(isAuthorized = auth.isAuthorized()))

    init {
        addAuthStateListener()
    }

    /**
     * Обработка события в активити(глобальные события)
     * @param event событие в активити
     */
    fun handleEvent(event: MainEvent) {
        when (event) {
            is MainEvent.ThemeChanged -> {
                changeTheme(event.theme)
            }
        }
    }

    /**
     * Добавляет колбэк на изменения состояния авторизации пользователя.
     */
    private fun addAuthStateListener() {
        auth.removeAllChangeListeners()
        auth.addChangeListener(object : AuthStateListener {
            override fun onAuthChanged(isAuthorized: Boolean) {
                updateIsAuthorized(isAuthorized = isAuthorized)

                if (isAuthorized) {
                    loadUser()
                }
            }
        })
    }

    /**
     * Является ли цветовая тема темной?
     *
     * @param theme цветовая тема
     * @return true если да, иначе false
     */
    fun isDark(theme: Theme): Boolean? {
        return themeUseCase.isDark(theme)
    }

    /**
     * Изменяет текущую цветовую тему
     *
     * @param theme новая цветовая тема
     */
    private fun changeTheme(theme: Theme) {
        themeUseCase.setTheme(theme)
        uiState.value = uiState.value.copy(theme = theme)
    }

    /**
     * Обновляет состояние авторизации
     *
     * @param isAuthorized авторизован пользователь или нет
     */
    private fun updateIsAuthorized(isAuthorized: Boolean) {
        uiState.value = uiState.value.copy(isAuthorized = isAuthorized)
    }

    /**
     * Получает данные о пользователе
     */
    private fun loadUser() {
        uiState.value = uiState.value.copy(getUserStatus = ActionStatus.Loading)

        viewModelScope.launch(Dispatchers.IO) {
            val result = getUserUseCase.invoke()

            withContext(Dispatchers.Main) {
                when (result) {
                    is Result.Success -> {
                        uiState.value = uiState.value.copy(
                            user = result.value,
                            getUserStatus = ActionStatus.Success
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