package com.asprog.featuredagger.di

import android.content.Context
import com.asprog.featuredagger.sample.MyHelper
import com.asprog.featuredagger.sample.MyHelperImpl
import com.asprog.featuredagger.ui.innerScreen.DaggerInnerActivity
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [(FeatureModule::class), (ChatDepsModule::class)],
    dependencies = [AppDependency::class]
)
interface ChatComponent {

    @Component.Builder
    interface Builder {
        fun appDependency(appDependency: AppDependency): Builder
        fun build(): ChatComponent
    }

    fun inject(daggerInnerActivity: DaggerInnerActivity)
}

@Module
abstract class FeatureActivityBuilderModule {

    @ContributesAndroidInjector(modules = [(ChatDepsModule::class)])
    abstract fun bindStartActivity(): DaggerInnerActivity

}

@Module
class ChatDepsModule {
    @Provides
    fun provideMyHelper(context: Context): MyHelper = MyHelperImpl(context)
}

