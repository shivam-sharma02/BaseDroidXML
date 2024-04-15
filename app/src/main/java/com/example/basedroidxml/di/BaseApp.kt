package com.example.basedroidxml.di

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApp: Application() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()
//        Log.isLogEnabled = BuildConfig.DEBUG

    }
}