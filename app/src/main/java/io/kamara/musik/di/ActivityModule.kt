package io.kamara.musik.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.kamara.musik.MusikActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun bindMusikActivity(): MusikActivity
}