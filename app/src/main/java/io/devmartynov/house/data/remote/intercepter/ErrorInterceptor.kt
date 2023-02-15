package io.devmartynov.house.data.remote.intercepter

import io.devmartynov.house.data.remote.enums.HttpCode
import io.devmartynov.house.app.model.AuthManager
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/**
 * Обрабатывает http ошибки
 *
 * @param authManager
 */
class ErrorInterceptor @Inject constructor(
    private val authManager: AuthManager,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(
            chain
                .request()
                .newBuilder()
                .build()
        )

        if (!response.isSuccessful) {
            when (response.code()) {
                HttpCode.FORBIDDEN.code -> {
                    authManager.signOut()
                }
                HttpCode.NOT_FOUND.code -> {
                    // todo implement
                }
                HttpCode.INTERNAL_SERVER_ERROR.code -> {
                    // todo show notification
                }
            }
        }

        return response;
    }
}