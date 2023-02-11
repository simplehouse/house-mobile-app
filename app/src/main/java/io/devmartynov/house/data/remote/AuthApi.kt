package io.devmartynov.house.data.remote

import io.devmartynov.house.data.remote.model.InitResponse
import io.devmartynov.house.data.remote.model.SignInResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * API сервис для авторизации
 */
interface AuthApi {

    @FormUrlEncoded
    @POST("auth/login")
    suspend fun signIn(
        @Field("login") login: String,
        @Field("password") password: String
    ): Response<SignInResponse>

    @POST("init")
    suspend fun init(): Response<InitResponse>
}