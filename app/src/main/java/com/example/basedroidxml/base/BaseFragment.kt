package com.example.basedroidxml.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding
import com.example.basedroidxml.R
import com.example.basedroidxml.utils.CommonUtils
import com.example.basedroidxml.utils.Utils
import java.util.regex.Matcher
import java.util.regex.Pattern

abstract class BaseFragment<B : ViewBinding> : Fragment() {

    @get:LayoutRes
    abstract val layoutId: Int
    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> B
    lateinit var navController: NavController
    private var progressDialog: Dialog? = null
    lateinit var binding: B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        session = SessionManager(requireContext())
        binding = bindingInflater.invoke(inflater, container, false)
        navController = Navigation.findNavController(requireActivity(), R.id.navHostFragment)
        try {
            Utils.hideKeyboard(requireActivity())
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressDialog = CommonUtils.showLoadingDialog(requireActivity())
    }

    fun showProgress() {
        hideProgress()
        if (progressDialog != null && !progressDialog!!.isShowing) {
            progressDialog!!.show()
        }
    }

    private fun hideProgress() {
        if (progressDialog != null && progressDialog!!.isShowing) {
            progressDialog!!.dismiss()
        }
    }

    fun isValidEmail(email: String): Boolean {
        val ragEx = Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")
        return email.matches(ragEx)
    }

    fun isPartem(password: String): Boolean {
        val pattern: Pattern

        val passwordPattern = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})"

        pattern = Pattern.compile(passwordPattern)
        val matcher: Matcher = pattern.matcher(password)

        return matcher.matches()
    }

}