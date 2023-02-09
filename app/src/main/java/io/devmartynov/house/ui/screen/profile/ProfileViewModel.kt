package io.devmartynov.house.ui.screen.profile

import androidx.lifecycle.ViewModel
import io.devmartynov.house.ui.screen.profile.model.ProfileEvent
import io.devmartynov.house.ui.screen.profile.model.ProfileState
import io.devmartynov.house.ui.shared.model.Theme
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * Вью модель профиля пользователя
 */
class ProfileViewModel : ViewModel() {
    val uiState = MutableStateFlow(ProfileState())

    init {
        getUserData()
    }

    /**
     * Обработка события на экране профиля пользователя
     *
     * @param event событие на экране профиля пользователя
     */
    fun handleEvent(event: ProfileEvent) {
        when (event) {
            is ProfileEvent.ThemeChanged -> {
                setTheme(event.theme)
            }
            ProfileEvent.ProfileDeleted -> {
                deleteProfile()
            }
        }
    }

    /**
     * Изменяет цветовую тему приложения
     *
     * @param theme цветовая тема приложения
     */
    private fun setTheme(theme: Theme) {
        if (uiState.value.theme != theme) {
            uiState.value = uiState.value.copy(theme = theme)
        }
    }

    /**
     * Удаляет профиль пользователя и редиректит на авторизацию
     */
    private fun deleteProfile() {
        // TODO repository method execution
        // TODO logout after deletion
    }

    /**
     * Получает информацию по пользователю
     */
    private fun getUserData() {
        // TODO repository method execution
        uiState.value = uiState.value.copy(
            fullName = "Мартынов Д.O.",
            imageUrl = "https://engineering.unl.edu/images/staff/Kayla-Person.jpg",
            email = "denis.martynov.93@mail.ru"
        )
    }
}