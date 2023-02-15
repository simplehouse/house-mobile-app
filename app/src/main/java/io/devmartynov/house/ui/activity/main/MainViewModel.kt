package io.devmartynov.house.ui.activity.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.devmartynov.house.app.model.*
import io.devmartynov.house.domain.useCase.GetUserUseCase
import io.devmartynov.house.domain.useCase.SetThemeUseCase
import io.devmartynov.house.ui.activity.main.model.MainEvent
import io.devmartynov.house.ui.activity.main.model.MainState
import io.devmartynov.house.domain.enums.Theme
import io.devmartynov.house.domain.useCase.GetThemeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Вью модель активити(в приложении только одна активити)
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val themeUseCase: SetThemeUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val getThemeUseCase: GetThemeUseCase,
    private val authManager: AuthManager,
    private val themeManager: ThemeManager,
) : ViewModel() {
    val uiState = MutableStateFlow(MainState(isAuthorized = authManager.isAuthorized()))

    init {
        addAuthStateListener()
        addThemeStateListener()
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
        authManager.addChangeListener(object : StateListener<Boolean> {
            override fun onChanged(value: Boolean) {
                uiState.value = uiState.value.copy(isAuthorized = value)

                if (value) {
                    loadUser()
                }
            }
        })
    }

    /**
     * Добавляет колбэк на изменения цветовой темы приложения.
     */
    private fun addThemeStateListener() {
        themeManager.addChangeListener(object : StateListener<Theme> {
            override fun onChanged(value: Theme) {
                uiState.value = uiState.value.copy(theme = value)
            }
        })
    }

    /**
     * Является ли цветовая тема темной?
     *
     * @return true если да, иначе false
     */
    fun isDarkTheme(): Boolean {
        return getThemeUseCase() == Theme.DARK
    }

    /**
     * Изменяет текущую цветовую тему
     *
     * @param theme новая цветовая тема
     */
    private fun changeTheme(theme: Theme) {
        themeUseCase(theme)
        uiState.value = uiState.value.copy(theme = theme)
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
                            getUserStatus = ActionStatus.Success()
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