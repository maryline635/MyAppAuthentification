package com.example.myappauthentification

import android.app.Application
import com.example.myappauthentification.app.data.dikoin.dataModule
import com.example.myappauthentification.app.data.dikoin.domainModule
import com.example.myappauthentification.app.data.dikoin.networkModule
import com.example.myappauthentification.app.data.dikoin.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)

            modules(
                networkModule,
                dataModule,
                domainModule,
                presentationModule
            )
        }
    }
}