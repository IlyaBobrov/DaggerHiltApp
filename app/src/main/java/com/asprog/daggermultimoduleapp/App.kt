package com.asprog.daggermultimoduleapp

import android.app.Application
import com.asprog.daggermultimoduleapp.di.AppComponent
import com.asprog.daggermultimoduleapp.di.DaggerAppComponent
import com.asprog.featuredagger.di.ChatComponent
import com.asprog.featuredagger.di.DaggerChatComponent
import com.asprog.featuredagger.di.DaggerWrapper
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    lateinit var appComponent: AppComponent
        private set

    lateinit var chatComponent: ChatComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .application(this)
            .build()

        appComponent.inject(this)

        chatComponent = DaggerChatComponent
            .builder()
            .appDependency(appComponent)
            .build()

        DaggerWrapper.mComponent = chatComponent
    }
}