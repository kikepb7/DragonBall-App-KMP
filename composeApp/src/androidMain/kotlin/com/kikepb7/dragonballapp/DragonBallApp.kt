package com.kikepb7.dragonballapp

import android.app.Application
import com.kikepb7.dragonballapp.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class DragonBallApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger()
            androidContext(androidContext = this@DragonBallApp)
        }
    }
}