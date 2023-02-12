package io.devmartynov.house.data.remote.intercepter

import io.devmartynov.house.data.remote.HttpCode
import io.devmartynov.house.app.model.Auth
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/**
 * Обрабатывает http ошибки
 *
 * @param auth
 */
class ErrorInterceptor @Inject constructor(
    private val auth: Auth
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
                    auth.signOut()
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