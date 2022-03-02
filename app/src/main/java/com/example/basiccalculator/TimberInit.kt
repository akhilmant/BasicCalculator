package com.example.basiccalculator

import android.app.Application
import timber.log.Timber

class TimberInit:Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}