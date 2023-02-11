package io.devmartynov.house.data.remote.intercepter

import io.devmartynov.house.domain.model.Auth
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

/**
 * Добавляет заголовки к запросу
 *
 * @param auth
 */
class HeaderInterceptor @Inject constructor(
    private val auth: Auth,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest: Request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer ${auth.getAccessToken()}")
            .build()
        return chain.proceed(newRequest)
    }
}