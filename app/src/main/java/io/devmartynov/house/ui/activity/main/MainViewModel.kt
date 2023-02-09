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
            is MainEvent.AuthorizationChanged -> {
            }
        }
    }

    fun addAuthStateListener(auth: Auth) {
        auth.addChangeListener(object : AuthStateListener {
            override fun onAuthChanged(isAuthorized: Boolean) {
                changeAuthorization(isAuthorized = isAuthorized)
            }
        })
    }

    fun isDark(theme: Theme): Boolean? {
        return themeUseCase.isDark(theme)
    }

    private fun changeTheme(theme: Theme) {
        themeUseCase.setTheme(theme)
        uiState.value = uiState.value.copy(theme = theme)
    }

    private fun changeAuthorization(isAuthorized: Boolean) {
        uiState.value = uiState.value.copy(isAuthorized = isAuthorized)
    }
}