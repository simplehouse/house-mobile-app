package io.devmartynov.house.ui.activity.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.devmartynov.house.domain.model.Auth
import io.devmartynov.house.domain.model.AuthStateListener
import io.devmartynov.house.domain.useCase.SetThemeUseCase
import io.devmartynov.house.ui.activity.main.model.MainEvent
import io.devmartynov.house.ui.activity.main.model.MainState
import io.devmartynov.house.ui.shared.model.Theme
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

/**
 * Вью модель активити(в приложении только одна активити)
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val themeUseCase: SetThemeUseCase,
) : ViewModel() {
    val uiState = MutableStateFlow(MainState())

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
     *
     * @param auth компонент авторизации приложения
     */
    fun addAuthStateListener(auth: Auth) {
        auth.removeAllChangeListeners()
        auth.addChangeListener(object : AuthStateListener {
            override fun onAuthChanged(isAuthorized: Boolean) {
                updateIsAuthorized(isAuthorized = isAuthorized)
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
}