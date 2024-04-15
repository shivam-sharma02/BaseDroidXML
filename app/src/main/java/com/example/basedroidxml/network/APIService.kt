package com.example.basedroidxml.network

import com.example.basedroidxml.model.AuthenticationModel
import com.example.basedroidxml.model.CommonModel
import com.example.basedroidxml.model.RequestBodies
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface APIService {

    @Headers("Accept: application/json")
    @POST("api/login")
    suspend fun loginAPI(@Body login: RequestBodies.LoginBody): AuthenticationModel

    @Headers("Accept: application/json")
    @POST("api/social-login")
    suspend fun socialLoginAPI(@Body login: RequestBodies.SocialLoginBody): AuthenticationModel

    @Headers("Accept: application/json")
    @POST("api/signup")
    suspend fun signupAPI(@Body signup: RequestBodies.SignUpBody): AuthenticationModel

    @Headers("Accept: application/json")
    @POST("api/forgot-password")
    suspend fun forgotPasswordAPI(@Body login: RequestBodies.ForgotPasswordBody): AuthenticationModel

    @Headers("Accept: application/json")
    @POST("api/change-password")
    suspend fun changePasswordAPI(
        @Header("Authorization") auth: String,
        @Body login: RequestBodies.ChangePasswordBody
    ): CommonModel
}