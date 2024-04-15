package com.example.basedroidxml.ui.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.example.basedroidxml.R
import com.example.basedroidxml.base.BaseFragment
import com.example.basedroidxml.databinding.FragmentLoginBinding
import com.facebook.CallbackManager
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(), View.OnClickListener {
    /**
     * Viewmodel needs to be initialized
     */
    private var doubleBackToExitPressedOnce = false
    private val mHandler: Handler = Handler(Looper.myLooper()!!)
    private var callbackManager: CallbackManager? = null

    override val layoutId: Int
        get() = R.layout.fragment_login

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentLoginBinding
        get() = FragmentLoginBinding::inflate


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        callbackManager = CallbackManager.Factory.create()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

        binding.btnLogin.setOnClickListener(this)
        binding.tvSignup.setOnClickListener(this)
        binding.tvForgotPassword.setOnClickListener(this)
        binding.imgGoogle.setOnClickListener(this)
        binding.imgFacebook.setOnClickListener(this)

    }

    private fun initView() {
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true /* enabled by default */) {
                override fun handleOnBackPressed() {
                    if (doubleBackToExitPressedOnce) {
                        requireActivity().finish()
                    }
                    doubleBackToExitPressedOnce = true
                    Toast.makeText(
                        requireActivity(),
                        "" + getString(R.string.exit_msg),
                        Toast.LENGTH_SHORT
                    ).show()

                    mHandler.postDelayed({
                        doubleBackToExitPressedOnce = false
                    }, 2000)
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }
//
//    private fun checkLoginValidation(): Boolean {
//        if (TextUtils.isEmpty(binding.etUserEmail.text.toString().trim())) {
//            requireActivity().showErrorMessage(getString(R.string.error_email))
//            binding.etUserEmail.requestFocus()
//            return false
//        } else if (!isValidEmail(binding.etUserEmail.text.toString().trim())) {
//            requireActivity().showErrorMessage(getString(R.string.error_valid_email))
//            binding.etUserEmail.requestFocus()
//            return false
//        } else if (TextUtils.isEmpty(binding.etUserPassword.text.toString().trim())) {
//            requireActivity().showErrorMessage(getString(R.string.error_password))
//            binding.etUserPassword.requestFocus()
//            return false
//        }
//
//        return true
//    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnLogin -> {
                /**
                 * Needs implementation
                 */
                Toast.makeText(context, "Implementation needed", Toast.LENGTH_SHORT).show()
            }
            R.id.tvForgotPassword -> {
                navController.navigate(R.id.forgotPasswordFragment)
            }
            R.id.tvSignup -> {
                navController.navigate(R.id.signUpFragment)
            }

            R.id.imgGoogle -> {
                /**
                 * Google Signin needs to be implemented
                 */
                Toast.makeText(context, "Implementation needed", Toast.LENGTH_SHORT).show()
            }
            R.id.imgFacebook -> {
                /**
                 * Facebook Signin needs to be implemented
                 */
                Toast.makeText(context, "Implementation needed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /**
     * Viewmodel observer needs to be implemented
     */

}