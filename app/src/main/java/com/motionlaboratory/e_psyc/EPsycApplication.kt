package com.motionlaboratory.e_psyc

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.motionlaboratory.e_psyc.source.network.EPsycRepository
import com.motionlaboratory.e_psyc.ui.main.MainViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import timber.log.Timber

class EPsycApplication : Application(), KodeinAware {


    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@EPsycApplication))

        bind() from singleton { EPsycRepository() }
        bind() from provider { MainViewModelFactory(instance()) }
    }


    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Timber.d("Run base application")
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}