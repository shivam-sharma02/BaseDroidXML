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
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

class SignupViewModel @Inject constructor(private val repository: MainRepository) : ViewModel(){

    private val signUpData = MutableLiveData<APIState<AuthenticationModel>>()
    val signUpObservable: LiveData<APIState<AuthenticationModel>>
        get() = signUpData

    fun signUp(
        name: String,
        email: String,
        password: String,
        countryCode: String,
        phone: String,
        deviceToken: String,
        deviceType: String
    ) = viewModelScope.launch {
        signUpData.value = APIState.Loading
        try {
            /**
             * Needs to be changed as per requirement
             */
            repository.signupAPI(
                RequestBodies.SignUpBody(
                    name, email, password, countryCode, phone,
                    deviceToken, deviceType,0
                ),
            ).catch { e ->
                if (e is HttpException) {
                    if (e.code() == 422) {
                        val errorResponse = e.response()!!.errorBody()!!.string()
                        val gson = Gson()
                        val thing: ErrorResponse =
                            gson.fromJson(errorResponse, ErrorResponse::class.java)
                        signUpData.value = APIState.Error(thing.message!!)
                    } else {
                        val errorResponse =
                            e.response()!!.errorBody()!!.string()
                        val gson = Gson()
                        val thing: ErrorResponse =
                            gson.fromJson(errorResponse, ErrorResponse::class.java)
                        signUpData.value = APIState.Error(thing.message!!)
                    }
                } else {
                    e.printStackTrace()
                    signUpData.value = if (e.message != null) APIState.Error(e.message!!) else {
                        APIState.Error(e.printStackTrace().toString())
                    }
                }

            }
                .collect {
                    signUpData.value = APIState.Success(it)
                }

        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

}