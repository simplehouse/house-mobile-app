package io.devmartynov.house.ui.screen.auth.signIn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.devmartynov.house.domain.useCase.SignInUseCase
import io.devmartynov.house.ui.screen.auth.model.PasswordRequirements
import io.devmartynov.house.ui.screen.auth.signIn.model.SignInEvent
import io.devmartynov.house.ui.screen.auth.signIn.model.SignInState
import io.devmartynov.house.app.model.ActionStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import io.devmartynov.house.app.model.Result

private const val MIN_PASSWORD_LENGTH = 8

/**
 * Вью модель авторизации пользователя
 */
@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase
) : ViewModel() {
    val uiState = MutableStateFlow(SignInState())

    /**
     * Обработка события на экране авторизации
     * @param signInEvent событие на экране авторизации
     */
    fun handleEvent(signInEvent: SignInEvent) {
        when (signInEvent) {
            is SignInEvent.EmailChanged -> {
                updateEmail(signInEvent.email)
            }
            is SignInEvent.PasswordChanged -> {
                updatePassword(signInEvent.password)
            }
            SignInEvent.ErrorDismissed -> {
                dismissError()
            }
            SignInEvent.SignIn -> {
                signIn()
            }
        }
    }

    /**
     * Убирает API ошибку авторизации
     */
    private fun dismissError() {
        uiState.value = uiState.value.copy(status = ActionStatus.Idle)
    }

    /**
     * Выполняет авторизацию пользователя
     */
    private fun signIn() {
        uiState.value = uiState.value.copy(status = ActionStatus.Loading)
        viewModelScope.launch(Dispatchers.IO) {
            val result = signInUseCase(
                email = uiState.value.email ?: "",
                password = uiState.value.password ?: "",
            )
            withContext(Dispatchers.Main) {
                when (result) {
                    is Result.Success -> {
                        uiState.value = uiState.value.copy(
                            status = ActionStatus.Success,
                            email = null,
                            password = null,
                        )
                    }
                    is Result.Failure -> {
                        uiState.value = uiState.value.copy(
                            status = ActionStatus.Error(result.errors)
                        )
                    }
                }
            }
        }
    }

    /**
     * Обновляет значение email в состоянии
     *
     * @param email новое значение email
     */
    private fun updateEmail(email: String) {
        uiState.value = uiState.value.copy(email = email)
    }

    /**
     * Обновляет в состоянии значение пароля и выполненных требований к паролю
     *
     * @param password новое значение пароля
     */
    private fun updatePassword(password: String) {
        val requirements = mutableListOf<PasswordRequirements>()

        if (password.length >= MIN_PASSWORD_LENGTH) {
            requirements.add(PasswordRequirements.EIGHT_CHARACTERS)
        }
        if (password.any { it.isUpperCase() }) {
            requirements.add(PasswordRequirements.CAPITAL_LETTER)
        }
        if (password.any { it.isDigit() }) {
            requirements.add(PasswordRequirements.NUMBER)
        }

        uiState.value = uiState.value.copy(
            password = password,
            completedPasswordRequirements = requirements
        )
    }
}