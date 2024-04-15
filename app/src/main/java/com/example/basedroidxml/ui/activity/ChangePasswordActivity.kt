package com.example.basedroidxml.ui.activity

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.view.WindowManager
import com.example.basedroidxml.R
import com.example.basedroidxml.databinding.ActivityChangePasswordBinding
import com.example.basedroidxml.utils.CommonUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChangePasswordActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityChangePasswordBinding
    private var progressDialog: Dialog? = null

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        binding =
            ActivityChangePasswordBinding.inflate(layoutInflater).apply { setContentView(root) }

        window.setFlags(
            WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
            WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED
        )
        initView()

    }

    private fun initView() {
        binding.toolbarApp.tvTitle.text = getString(R.string.change_password)
        binding.toolbarApp.ivLeft.visibility = View.VISIBLE
        binding.toolbarApp.ivLeft.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        progressDialog = CommonUtils.showLoadingDialog(this)
        binding.btnSend.setOnClickListener(this)

        binding.tlNewPassword.setEndIconOnClickListener {
            if (binding.etConfPassword.transformationMethod == null) {
                binding.etConfPassword.transformationMethod = PasswordTransformationMethod()
            } else {
                binding.etConfPassword.transformationMethod = null
            }
            binding.etConfPassword.setSelection(binding.etConfPassword.text!!.length)

            if (binding.etUserNewPassword.transformationMethod == null) {
                binding.etUserNewPassword.transformationMethod = PasswordTransformationMethod()
            } else {
                binding.etUserNewPassword.transformationMethod = null
            }
            binding.etUserNewPassword.setSelection(binding.etUserNewPassword.text!!.length)
        }
    }
/**
 * sample code for validation of password
 */
//    private fun validation(): Boolean {
//        if (TextUtils.isEmpty(binding.etUserOldPassword.text.toString().trim())) {
//            this.showErrorMessage(getString(R.string.error_current_password))
//            binding.etUserOldPassword.requestFocus()
//            return false
//        } else if (TextUtils.isEmpty(binding.etUserNewPassword.text.toString().trim())) {
//            this.showErrorMessage(getString(R.string.error_new_password))
//            binding.etUserNewPassword.requestFocus()
//            return false
//        } else if (!isPartem(binding.etUserNewPassword.text.toString().trim())) {
//            this.showErrorMessage(getString(R.string.error_valid_password))
//            binding.etUserNewPassword.requestFocus()
//            return false
//        } else if (TextUtils.isEmpty(binding.etConfPassword.text.toString().trim())) {
//            this.showErrorMessage(getString(R.string.enter_your_confirm_pass))
//            binding.etConfPassword.requestFocus()
//            return false
//        } else if (binding.etUserNewPassword.text.toString()
//                .trim() != binding.etConfPassword.text.toString().trim()
//        ) {
//            this.showErrorMessage(getString(R.string.error_password_match))
//            binding.etConfPassword.requestFocus()
//            return false
//        }
//        return true
//    }

//    private fun isPartem(password: String): Boolean {
//        val pattern: Pattern
//
//        val passwordPattern = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})"
//
//        pattern = Pattern.compile(passwordPattern)
//        val matcher: Matcher = pattern.matcher(password)
//
//        return matcher.matches()
//    }

//    fun showProgress() {
//        hideProgress()
//        if (progressDialog != null && !progressDialog!!.isShowing) {
//            progressDialog!!.show()
//        }
//    }

//    fun hideProgress() {
//        if (progressDialog != null && progressDialog!!.isShowing) {
//            progressDialog!!.dismiss()
//        }
//    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.ivLeft -> {
                onBackPressedDispatcher.onBackPressed()
            }

            /**
             * Send btn needs to be implemented
             */
        }
    }

    /**
     * View model need to be observed
     */
}