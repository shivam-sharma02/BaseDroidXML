package com.example.basedroidxml.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.basedroidxml.R
import com.example.basedroidxml.base.BaseFragment
import com.example.basedroidxml.databinding.FragmentForgotPasswordBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ForgotPasswordFragment : BaseFragment<FragmentForgotPasswordBinding>(), View.OnClickListener {

    /**
     * Viewmodel needs to be initialized
     */

    override val layoutId: Int
        get() = R.layout.fragment_forgot_password

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentForgotPasswordBinding
        get() = FragmentForgotPasswordBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        binding.toolbarApp.toolbarLayout.setBackgroundColor(requireActivity().getColor(R.color.scree_bg))
        binding.toolbarApp.ivLeft.visibility = View.VISIBLE
        binding.toolbarApp.ivLeft.setOnClickListener(this)
        binding.btnSend.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.ivLeft -> {
                navController.popBackStack()
            }

            /**
             * Send btn needs to be implemented
             */
        }
    }

//    private fun validation(): Boolean {
//        if (TextUtils.isEmpty(binding.etUserEmail.text.toString().trim())) {
//            requireActivity().showErrorMessage(getString(R.string.error_email))
//            binding.etUserEmail.requestFocus()
//            return false
//        } else if (!isValidEmail(binding.etUserEmail.text.toString().trim())) {
//            requireActivity().showErrorMessage(getString(R.string.error_valid_email))
//            binding.etUserEmail.requestFocus()
//            return false
//        }
//        return true
//    }

    /**
     * Viewmodel Observer needs to be implemented
     */

}