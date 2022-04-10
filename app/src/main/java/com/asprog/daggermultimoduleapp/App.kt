package com.asprog.daggermultimoduleapp

import android.app.Application
import com.asprog.daggermultimoduleapp.di.AppComponent
import com.asprog.daggermultimoduleapp.di.DaggerAppComponent
import com.asprog.featuredagger.di.deps.AppDependencyStore
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .application(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
        AppDependencyStore.dependency = appComponent
    }
}