package io.kamara.musik.di

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import io.kamara.musik.MusikActivity
import io.kamara.musik.MusikApplication
import javax.inject.Singleton

@Module
object ApplicationModule {

    @Provides
    @JvmStatic
    @Singleton
    internal  fun provideApplication(app: MusikApplication): Application = app

    @Provides
    @JvmStatic
    @Singleton
    fun providesConnectivityManager(app: Application): ConnectivityManager =
        app.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
}