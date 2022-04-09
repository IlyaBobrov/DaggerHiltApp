package com.asprog.featuredagger.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class FeatureModule {
    @Provides
    fun provideContext(application: Application): Context = application
}