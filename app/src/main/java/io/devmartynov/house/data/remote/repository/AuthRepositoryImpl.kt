package io.devmartynov.house.data.remote.repository

import io.devmartynov.house.data.remote.AuthApi
import io.devmartynov.house.data.remote.mappers.toDomainModel
import io.devmartynov.house.app.model.Result
import io.devmartynov.house.domain.model.SignInResponse
import io.devmartynov.house.domain.repositories.AuthRepository
import javax.inject.Inject
import io.devmartynov.house.domain.model.User

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi
) : AuthRepository {
    override suspend fun signIn(email: String, password: String): Result<SignInResponse> {
        try {
            val response = authApi.signIn(
                login = email,
                password = password
            )

            if (response.isSuccessful) {
                if (response.body() == null) {
                    return Result.Failure(response.errorBody().toString())
                }
                if (response.body()?.errors != null) {
                    val emailError = response.body()?.errors?.email ?: ""
                    val passwordError = response.body()?.errors?.password ?: ""
                    return Result.Failure("$emailError. $passwordError")
                }
                val accessToken = response.body()!!.accessToken
                return Result.Success(
                    SignInResponse(
                        errors = null,
                        accessToken = accessToken
                    )
                )
            }
            return Result.Failure(
                "Error while signing in. Error: ${
                    response.errorBody().toString()
                }"
            )
        } catch (e: Exception) {
            return Result.Failure(e.message.toString())
        }
    }

    override suspend fun getUser(): Result<User> {
        try {
            val response = authApi.init()

            if (response.isSuccessful) {
                if (response.body() == null) {
                    return Result.Failure(response.errorBody().toString())
                }
                val user = response.body()!!.user.toDomainModel()
                return Result.Success(user)
            }
            return Result.Failure(
                "Error while init executing. Error: ${
                    response.errorBody().toString()
                }"
            )
        } catch (e: Exception) {
            return Result.Failure(e.message.toString())
        }
    }
}