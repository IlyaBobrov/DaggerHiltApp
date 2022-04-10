package com.asprog.featuredagger.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.asprog.featuredagger.di.deps.AppDependency
import com.asprog.featuredagger.sample.MyHelper
import com.asprog.featuredagger.sample.MyHelperImpl
import com.asprog.featuredagger.ui.innerScreen.DaggerInnerActivity
import com.asprog.featuredagger.ui.innerScreen.fragments.chat.ChatFragment
import com.asprog.featuredagger.ui.innerScreen.fragments.chat.ChatViewModel
import com.asprog.featuredagger.ui.innerScreen.fragments.chat.MyViewModelFactory
import com.asprog.featuredagger.ui.innerScreen.fragments.media.MediaFragment
import com.asprog.featuredagger.ui.innerScreen.fragments.media.MediaViewModel
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Singleton
@Component(
    modules = [(FeatureModule::class), (ChatDepsModule::class), (ViewModelModule::class)],
    dependencies = [AppDependency::class]
)
internal interface ChatComponent {

    @Component.Builder
    interface Builder {
        fun appDependency(appDependency: AppDependency): Builder
        fun build(): ChatComponent
    }

    fun inject(daggerInnerActivity: DaggerInnerActivity)
    fun inject(chatFragment: ChatFragment)
    fun inject(mediaFragment: MediaFragment)
}

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: MyViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ChatViewModel::class)
    abstract fun chatViewModel(viewModel: ChatViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MediaViewModel::class)
    abstract fun mediaViewModel(viewModel: MediaViewModel): ViewModel

}

@Module
class ChatDepsModule {
    @Provides
    fun provideMyHelper(context: Context): MyHelper = MyHelperImpl(context)
}

