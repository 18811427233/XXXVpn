package com.demo.xxxvpn.data.network

import android.os.Build
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class CommonHeaderInterceptor : Interceptor {

    companion object {
        @JvmStatic
        fun deviceHeaders() = mapOf<String, String>(
            "x-device-os" to "android",
            "x-device-model" to Build.MODEL,
            "x-device-os-version" to Build.VERSION.RELEASE
        )
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .apply {
                deviceHeaders().forEach { (key, value) -> addHeader(key, value) }
            }
            .build()
        return chain.proceed(newRequest)
    }
}
