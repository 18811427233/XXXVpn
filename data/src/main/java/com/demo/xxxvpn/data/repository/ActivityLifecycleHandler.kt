package com.demo.xxxvpn.data.repository

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.demo.xxxvpn.domain.ADEvent
import com.demo.xxxvpn.domain.repository.CacheRepository
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Activity lifecycle handler
 */
@Singleton
class ActivityLifecycleHandler @Inject constructor(
    private val cacheRepository: CacheRepository
) : Application.ActivityLifecycleCallbacks {
    // The current App Activity
    private var currentActivity: Activity? = null

    // Attributes to detect if app changes between background and foreground
    // Keep the count of number of Activities in the started state
    private var activityReferences = 0

    // Flag to indicate if the current Activity is going through configuration change like orientation switch
    private var isActivityChangingConfigurations = false

    private var firstTimeLaunch = true

    /**
     * On activity created
     *
     * @param activity
     * @param savedInstanceState
     */
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}

    /**
     * On activity started
     *
     * @param activity
     */
    override fun onActivityStarted(activity: Activity) {
        currentActivity = activity
        if (++activityReferences == 1 && !isActivityChangingConfigurations) {
            Timber.i("monitorAd App enters foreground")
            if (firstTimeLaunch) {
                firstTimeLaunch = false
                return
            }
            showAd()
        }
    }

    private fun showAd() {
        cacheRepository.monitorADEvent().value = ADEvent.AD_BACK_TO_TOP
    }

    /**
     * On activity resumed
     *
     * @param activity
     */
    override fun onActivityResumed(activity: Activity) {
        currentActivity = activity
    }

    /**
     * On activity paused
     *
     * @param activity
     */
    override fun onActivityPaused(activity: Activity) {
    }

    /**
     * On activity stopped
     *
     * @param activity
     */
    override fun onActivityStopped(activity: Activity) {
        isActivityChangingConfigurations = activity.isChangingConfigurations
        if (--activityReferences == 0 && !isActivityChangingConfigurations) {
            Timber.i("monitorAd App enters background")
        }
    }

    /**
     * On activity save instance state
     *
     * @param activity
     * @param outState
     */
    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}

    /**
     * On activity destroyed
     *
     * @param activity
     */
    override fun onActivityDestroyed(activity: Activity) {}

    /**
     * Get current activity
     *
     * @return current visible activity
     */
    fun getCurrentActivity(): Activity? = currentActivity

}