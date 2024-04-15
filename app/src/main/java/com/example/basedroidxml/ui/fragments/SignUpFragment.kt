package com.example.basedroidxml.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.basedroidxml.R
import com.example.basedroidxml.base.BaseFragment
import com.example.basedroidxml.databinding.FragmentSignUpBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : BaseFragment<FragmentSignUpBinding>(), View.OnClickListener {

    /**
     * View model implementation needed
     */


    override val layoutId: Int
        get() = R.layout.fragment_sign_up

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSignUpBinding
        get() = FragmentSignUpBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

    }

    private fun initView() {
        binding.btnSignup.setOnClickListener(this)
        binding.tvLogin.setOnClickListener(this)
        binding.tvCheckEnable.setOnClickListener(this)
        binding.icExpandCountry.setOnClickListener(this)
        binding.layoutSelectCountry.setOnClickListener(this)

        binding.tlPassword.setEndIconOnClickListener {
            if (binding.etUserConfPassword.transformationMethod == null) {
                binding.etUserConfPassword.transformationMethod = PasswordTransformationMethod()
            } else {
                binding.etUserConfPassword.transformationMethod = null
            }
            binding.etUserConfPassword.setSelection(binding.etUserConfPassword.text!!.length)

            if (binding.etUserPassword.transformationMethod == null) {
                binding.etUserPassword.transformationMethod = PasswordTransformationMethod()
            } else {
                binding.etUserPassword.transformationMethod = null
            }
            binding.etUserPassword.setSelection(binding.etUserPassword.text!!.length)
        }
    }

//    private fun checkLoginValidation(): Boolean {
//        if (TextUtils.isEmpty(binding.etUserName.text.toString().trim())) {
//            requireActivity().showErrorMessage(getString(R.string.error_name))
//            binding.etUserName.requestFocus()
//            return false
//        } else if (TextUtils.isEmpty(binding.etUserEmail.text.toString().trim())) {
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
//        } else if (!isPartem(binding.etUserPassword.text.toString().trim())) {
//            requireActivity().showErrorMessage(getString(R.string.error_valid_password))
//            binding.etUserPassword.requestFocus()
//            return false
//        } else if (TextUtils.isEmpty(binding.etUserConfPassword.text.toString().trim())) {
//            requireActivity().showErrorMessage(getString(R.string.enter_your_conf_pass))
//            binding.etUserConfPassword.requestFocus()
//            return false
//        } else if (binding.etUserPassword.text.toString()
//                .trim() != binding.etUserConfPassword.text.toString().trim()
//        ) {
//            requireActivity().showErrorMessage(getString(R.string.error_password_match))
//            binding.etUserConfPassword.requestFocus()
//            return false
//        } else if (!binding.notiCheck.isChecked) {
//            requireActivity().showErrorMessage(getString(R.string.error_accept_tnc))
//            return false
//        }
//        return true
//    }

    override fun onClick(v: View?) {
        when (v!!.id) {

            R.id.tvLogin -> {
                navController.popBackStack()
            }
            R.id.icExpandCountry -> {
                binding.ccp.setOnCountryChangeListener {

                    val countryName = binding.ccp.selectedCountryName
                    val countryCode = binding.ccp.selectedCountryCode
                    val countryCodeName = binding.ccp.selectedCountryNameCode
                    val countryCodeWithPlus = binding.ccp.selectedCountryCodeWithPlus


                    Toast.makeText(context, "$countryName, $countryCode, $countryCodeName, $countryCodeWithPlus", Toast.LENGTH_SHORT).show()

                }
            }
            R.id.tvCheckEnable -> {
                val browserIntent =
                    /**
                     * Uri string needs to be updated
                     */
                    Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"))
                startActivity(browserIntent)

            }
        }
    }

    /**
     * View model Observer needs to be implemented as per requirement
     */

}