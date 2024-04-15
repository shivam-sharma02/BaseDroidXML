package com.example.basedroidxml.ui.activity

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basedroidxml.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation =ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_main)

        initView()
    }

//    private val navController by lazy {
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment?
//        navHostFragment!!.navController
//    }

    private fun initView() {
        try {
//            if (intent.hasExtra(Constants.KEY_LOGOUT)) {
////                navController.navigate(R.id.loginFragment)
//            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}