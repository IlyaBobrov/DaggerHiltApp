package com.asprog.featuredagger.di.deps

import androidx.lifecycle.ViewModel
import com.asprog.featuredagger.di.DaggerChatComponent
import kotlin.properties.Delegates.notNull

internal class AppDependencyComponentViewModel : ViewModel() {
    val newAppDependencyComponent =
        DaggerChatComponent
            .builder()
            .appDependency(AppDependencyProvider.dependency)
            .build()
}

interface AppDependencyProvider {
    val dependency: AppDependency

    companion object : AppDependencyProvider by AppDependencyStore
}

object AppDependencyStore : AppDependencyProvider {
    override var dependency: AppDependency by notNull()
}