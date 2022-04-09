package com.asprog.featuredagger.di

import android.app.Application

interface AppDependency {
    fun application(): Application
}