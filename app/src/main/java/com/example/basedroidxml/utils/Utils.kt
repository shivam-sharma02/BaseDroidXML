package com.example.basedroidxml.utils

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager

class Utils {
    companion object {

        fun hideKeyboard(activity: Activity) {
            try {
                val imm =
                    activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                //Find the currently focused view, so we can grab the correct window token from it.
                var view = activity.currentFocus
                //If no view currently has focus, create a new one, just so we can grab a window token from it
                if (view == null) {
                    view = View(activity)
                }
                imm.hideSoftInputFromWindow(view.windowToken, 0)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        /**
         * Sample code for error message
         */

//        fun Context.showErrorMessage(message: String) {
//            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
//        }

        /**
         * Sample code to show single button dialog
         */

//        fun showSingleButtonDialog(
//            context: Context,
//            viewType: Int,
//            onAcceptRejectRequestListener: OnAcceptRejectRequestListener
//        ) {
//            val dialog = Dialog(context)
//            val layoutId = when (viewType) {
//                0 -> {
//                    R.layout.dialog_accept_and_login
//                }
//                else -> {
//                    0
//                }
//            }
//            dialog.setCanceledOnTouchOutside(false)
//            dialog.setCancelable(false)
//            dialog.setContentView(layoutId)
//
//            //findViewById
//            val btnPositiveButton = dialog.findViewById<View>(R.id.btnPositiveButton)
//            val imgCloseIcon = dialog.findViewById<View>(R.id.imgCloseIcon)
//            val termsAndConditionLink = dialog.findViewById<View>(R.id.txtDalTermsConditionTitle)
//
//            termsAndConditionLink.setOnClickListener {
//                val browserIntent =
//                    /**
//                     * Uri String needs to be updated for terms and condition
//                     */
//                    Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"))
//                context.startActivity(browserIntent)
//            }
//
//            //SetListener
//            imgCloseIcon.setOnClickListener {
//                onAcceptRejectRequestListener.onAcceptRejectClick(0, 0,0)
//                dialog.dismiss()
//            }
//
//            btnPositiveButton.setOnClickListener {
//                onAcceptRejectRequestListener.onAcceptRejectClick(0, 1,0)
//                dialog.dismiss()
//            }
//
//            val width =
//                ((context as AppCompatActivity).resources.displayMetrics.widthPixels * 0.90).toInt()
//
//            dialog.window?.setLayout(width, WindowManager.LayoutParams.WRAP_CONTENT)
//
//            dialog.show()
//        }
//
//    }
    }
}