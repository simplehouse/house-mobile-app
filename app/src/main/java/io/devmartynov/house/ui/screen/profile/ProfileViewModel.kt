package io.devmartynov.house.ui.screen.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.devmartynov.house.domain.useCase.GetUserUseCase
import io.devmartynov.house.ui.screen.profile.model.ProfileEvent
import io.devmartynov.house.ui.screen.profile.model.ProfileState
import io.devmartynov.house.ui.shared.model.Theme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import io.devmartynov.house.domain.model.Result
import io.devmartynov.house.domain.useCase.SignOutUseCase
import kotlinx.coroutines.withContext

/**
 * Вью модель профиля пользователя
 */
@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val signOutUseCase: SignOutUseCase,
) : ViewModel() {
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
            is ProfileEvent.SignOut -> {
                signOutUseCase()
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
        viewModelScope.launch(Dispatchers.IO) {
            val result = getUserUseCase()

            withContext(Dispatchers.IO) {
                when (result) {
                    is Result.Success -> {
                        uiState.value = uiState.value.copy(
                            fullName = result.value.name,
                            imageUrl = result.value.avatarUrl,
                            email = result.value.email,
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