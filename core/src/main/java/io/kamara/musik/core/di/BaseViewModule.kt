package io.kamara.musik.core.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import io.kamara.musik.core.view.ViewModelFactory
import javax.inject.Singleton

@Module
@Suppress("unused")
abstract class BaseViewModule {

    @Singleton
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory
}