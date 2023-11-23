package com.demo.xxxvpn

import android.app.Application
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.os.StrictMode.VmPolicy
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.color.DynamicColors
import com.demo.xxxvpn.data.repository.ActivityLifecycleHandler
import com.demo.xxxvpn.domain.repository.ADRepository
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject


@HiltAndroidApp
class VpnApplication : Application() {

    @Inject
    lateinit var activityLifecycleHandler: ActivityLifecycleHandler

    @Inject
    lateinit var adRepository: ADRepository

    override fun onCreate() {
        super.onCreate()
        DynamicColors.applyToActivitiesIfAvailable(this)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            StrictMode.setVmPolicy(VmPolicy.Builder().detectAll().penaltyLog().build())
            StrictMode.setThreadPolicy(ThreadPolicy.Builder().detectAll().penaltyLog().build())
        }
        registerActivityLifecycleCallbacks(activityLifecycleHandler)
        adRepository.init()
//        FacebookSdk.setApplicationId(packageName)
    }

    companion object {
        private const val TAG = "Application"
    }
}
