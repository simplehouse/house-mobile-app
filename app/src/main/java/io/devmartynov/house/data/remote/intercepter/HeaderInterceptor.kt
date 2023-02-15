package io.devmartynov.house.data.remote.intercepter

import io.devmartynov.house.app.model.AuthManager
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

/**
 * Добавляет заголовки к запросу
 *
 * @param authManager
 */
class HeaderInterceptor @Inject constructor(
    private val authManager: AuthManager
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest: Request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer ${authManager.getAccessToken()}")
            .build()
        return chain.proceed(newRequest)
    }
}