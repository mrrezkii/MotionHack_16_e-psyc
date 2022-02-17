package com.motionlaboratory.e_psyc

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import timber.log.Timber

class EPsycApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Timber.d("Run base application ${BuildConfig.VERSION_NAME}")
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}