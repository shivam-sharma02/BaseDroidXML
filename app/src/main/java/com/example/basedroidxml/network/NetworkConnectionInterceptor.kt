package com.example.basedroidxml.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class NetworkConnectionInterceptor(context : Context) : Interceptor {

    val applicationContext = context.applicationContext!!

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        if (!isInternetAvailable()) {
            throw NoConnectivityException()
//            return chain.proceed(
//                request.newBuilder().header(
//                    "Cache-Control",
//                    "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7
//                ).build()
//            )
        }
        return chain.proceed(
            request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
        )
    }

    private fun isInternetAvailable(): Boolean {
        val cm = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        cm.activeNetwork?.let { network ->
            cm.getNetworkCapabilities(network)?.let { cap ->
                if (cap.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)) {
                    return true
                }
            }
        }
        return false
    }

    class NoConnectivityException : IOException() {
        override val message: String
            get() = "No internet connection"
    }

}