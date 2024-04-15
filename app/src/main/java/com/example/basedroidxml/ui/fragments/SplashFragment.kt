package com.example.basedroidxml.ui.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.basedroidxml.R
import com.example.basedroidxml.base.BaseFragment
import com.example.basedroidxml.databinding.FragmentSplashBinding


class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_splash

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSplashBinding
        get() = FragmentSplashBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler(Looper.myLooper()!!).postDelayed({ setIntent() }, 3000)

    }

    private fun setIntent() {
        if (!navController.currentDestination!!.label!!.contains(LoginFragment::class.java.simpleName) && !navController.currentDestination!!.label!!.contains(
                SignUpFragment::class.java.simpleName
            ) && !navController.currentDestination!!.label!!.contains(
                ForgotPasswordFragment::class.java.simpleName
            )
        )
            navController.navigate(R.id.loginFragment)
    }
}
