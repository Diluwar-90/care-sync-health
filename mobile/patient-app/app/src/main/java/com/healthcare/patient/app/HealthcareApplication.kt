package com.healthcare.patient.app

import android.app.Application
import com.healthcare.patient.core.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HealthcareApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

            androidContext(this@HealthcareApplication)

            modules(appModules)

        }
    }

}