package com.demo.xxxvpn.util

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper

/**
 * Safe method to get Activity instance from Jetpack Compose recommended by Google
 * @see <a href="https://github.com/google/accompanist/blob/6611ebda55eb2948eca9e1c89c2519e80300855a/permissions/src/main/java/com/google/accompanist/permissions/PermissionsUtil.kt#L99">Sample</a>
 */
fun Context.findActivity(): Activity {
    var context = this
    while (context is ContextWrapper) {
        if (context is Activity) return context
        context = context.baseContext
    }
    throw IllegalStateException("no activity")
}