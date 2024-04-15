package com.example.basedroidxml.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basedroidxml.model.AuthenticationModel
import com.example.basedroidxml.model.ErrorResponse
import com.example.basedroidxml.model.RequestBodies
import com.example.basedroidxml.repository.MainRepository
import com.example.basedroidxml.utils.APIState
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: MainRepository) : ViewModel(){

    private val logInData = MutableLiveData<APIState<AuthenticationModel>>()
    val logInObservable: LiveData<APIState<AuthenticationModel>> get() = logInData


    fun callLogin(
        email: String, password: String, deviceToken: String, deviceType: String
    ) =
        viewModelScope.launch {
            logInData.value = APIState.Loading
            try {
                /**
                 * Needs to be changed as per requirement
                 */
                repository.loginAPI(
                    RequestBodies.LoginBody(
                        email, password, deviceToken, deviceType
                    ),
                ).catch { e ->
                    if (e is HttpException) {
                        if (e.code() == 422) {
                            val errorResponse = e.response()!!.errorBody()!!.string()
                            val gson = Gson()
                            val thing: ErrorResponse =
                                gson.fromJson(errorResponse, ErrorResponse::class.java)
                            logInData.value = APIState.Error(thing.message!!)
                        } else if (e.code() == 400) {
                            val errorResponse =
                                e.response()!!.errorBody()!!.string()
                            val gson = Gson()
                            val thing: ErrorResponse =
                                gson.fromJson(errorResponse, ErrorResponse::class.java)
                            logInData.value = APIState.Error(thing.message!!)
                        } else if (e.code() == 405) {
                            val errorResponse =
                                e.response()!!.errorBody()!!.string()
                            val gson = Gson()
                            val thing: ErrorResponse =
                                gson.fromJson(errorResponse, ErrorResponse::class.java)
                            logInData.value = APIState.Error(thing.message!!)
                        }
                    } else {
                        e.printStackTrace()
                        logInData.value = if (e.message != null) APIState.Error(e.message!!) else {
                            APIState.Error(e.printStackTrace().toString())
                        }
                    }
                }.collect {
                    logInData.value = APIState.Success(it)
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
                logInData.value = APIState.Error(ex.printStackTrace().toString())
            }
        }

    fun socialLoginAPI(
        email: String,
        provider: String,
        socialToken: String,
        deviceToken: String,
        deviceType: String
    ) =
        viewModelScope.launch {
            logInData.value = APIState.Loading
            try {
                repository.socialLoginAPI(
                    RequestBodies.SocialLoginBody(
                        email,
                        provider,
                        socialToken,
                        deviceToken,
                        deviceType
                    ),
                ).catch { e ->
                    if (e is HttpException) {
                        if (e.code() == 422) {
                            val errorResponse = e.response()!!.errorBody()!!.string()
                            val gson = Gson()
                            val thing: ErrorResponse =
                                gson.fromJson(errorResponse, ErrorResponse::class.java)
                            logInData.value = APIState.Error(thing.message!!)
                        } else {
                            val errorResponse =
                                e.response()!!.errorBody()!!.string()
                            val gson = Gson()
                            val thing: ErrorResponse =
                                gson.fromJson(errorResponse, ErrorResponse::class.java)
                            logInData.value = APIState.Error(thing.message!!)
                        }
                    } else {
                        e.printStackTrace()
                        logInData.value = if (e.message != null) APIState.Error(e.message!!) else {
                            APIState.Error(e.printStackTrace().toString())
                        }
                    }
                }.collect {
                    logInData.value = APIState.Success(it)
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
                logInData.value = APIState.Error(ex.printStackTrace().toString())
            }
        }

}