package com.example.basedroidxml.network

import com.example.basedroidxml.model.AuthenticationModel
import com.example.basedroidxml.model.CommonModel
import com.example.basedroidxml.model.RequestBodies
import javax.inject.Inject


class ApiServiceImpl @Inject constructor(private val apiService: APIService) {

    suspend fun loginAPI(loginAPIBody: RequestBodies.LoginBody): AuthenticationModel =
        apiService.loginAPI(loginAPIBody)

    suspend fun socialLoginAPI(loginAPIBody: RequestBodies.SocialLoginBody): AuthenticationModel =
        apiService.socialLoginAPI(loginAPIBody)

    suspend fun signupAPI(signUpBody: RequestBodies.SignUpBody): AuthenticationModel =
        apiService.signupAPI(signUpBody)

    suspend fun forgotPasswordAPI(loginAPIBody: RequestBodies.ForgotPasswordBody): AuthenticationModel =
        apiService.forgotPasswordAPI(loginAPIBody)

    suspend fun changePasswordAPI(token: String, param: RequestBodies.ChangePasswordBody): CommonModel =
        apiService.changePasswordAPI(token, param)
}