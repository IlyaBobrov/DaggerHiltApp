package com.asprog.daggermultimoduleapp.di

import android.app.Application
import com.asprog.daggermultimoduleapp.App
import com.asprog.featuredagger.di.deps.AppDependency
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [],
    dependencies = []
)
interface AppComponent : AppDependency {

    override val application: Application

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}

