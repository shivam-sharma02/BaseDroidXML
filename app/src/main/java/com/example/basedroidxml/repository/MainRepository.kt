package com.example.basedroidxml.repository

import com.example.basedroidxml.model.AuthenticationModel
import com.example.basedroidxml.model.CommonModel
import com.example.basedroidxml.model.RequestBodies
import com.example.basedroidxml.network.ApiServiceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiServiceImpl: ApiServiceImpl) {

    fun loginAPI(loginBody: RequestBodies.LoginBody): Flow<AuthenticationModel> = flow {
        emit(apiServiceImpl.loginAPI(loginBody))
    }.flowOn(Dispatchers.IO)

    fun socialLoginAPI(loginBody: RequestBodies.SocialLoginBody): Flow<AuthenticationModel> = flow {
        emit(apiServiceImpl.socialLoginAPI(loginBody))
    }.flowOn(Dispatchers.IO)

    fun signupAPI(signUpBody: RequestBodies.SignUpBody): Flow<AuthenticationModel> = flow {
        emit(apiServiceImpl.signupAPI(signUpBody))
    }.flowOn(Dispatchers.IO)

    fun forgotPasswordAPI(loginBody: RequestBodies.ForgotPasswordBody): Flow<AuthenticationModel> = flow {
        emit(apiServiceImpl.forgotPasswordAPI(loginBody))
    }.flowOn(Dispatchers.IO)

    fun changePasswordAPI(token: String,changePasswordBody: RequestBodies.ChangePasswordBody): Flow<CommonModel> = flow {
        emit(apiServiceImpl.changePasswordAPI(token,changePasswordBody))
    }.flowOn(Dispatchers.IO)
}