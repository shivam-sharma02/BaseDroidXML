package com.example.basedroidxml.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basedroidxml.model.CommonModel
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
class ChangePasswordViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    private val changePasswordModel = MutableLiveData<APIState<CommonModel>>()
    val logInObservable: LiveData<APIState<CommonModel>> get() = changePasswordModel


    fun callChangePassword(
        token: String,
        oldPassword: String,
        newPassword: String,
        confirmPassword: String
    ) =
        viewModelScope.launch {
            changePasswordModel.value = APIState.Loading
            try {
                /**
                 * Needs to be updated as per requirement
                 */

                repository.changePasswordAPI(
                    token,
                    RequestBodies.ChangePasswordBody(oldPassword, newPassword, confirmPassword)
                ).catch { e ->
                    if (e is HttpException) {
                        if (e.code() == 422) {
                            val errorResponse = e.response()!!.errorBody()!!.string()
                            val gson = Gson()
                            val thing: ErrorResponse =
                                gson.fromJson(errorResponse, ErrorResponse::class.java)
                            changePasswordModel.value = APIState.Error(thing.message!!)
                        } else {
                            val errorResponse =
                                e.response()!!.errorBody()!!.string()
                            val gson = Gson()
                            val thing: ErrorResponse =
                                gson.fromJson(errorResponse, ErrorResponse::class.java)
                            changePasswordModel.value = APIState.Error(thing.message!!)
                        }
                    } else {
                        e.printStackTrace()
                        changePasswordModel.value = if (e.message != null) APIState.Error(e.message!!) else {
                            APIState.Error(e.printStackTrace().toString())
                        }

                    }
                }.collect {
                    changePasswordModel.value = APIState.Success(it)

                }
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }

}