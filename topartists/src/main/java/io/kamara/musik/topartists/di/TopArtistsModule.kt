package io.kamara.musik.topartists.di


import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.kamara.musik.topartists.view.TopArtistsFragment

@Module
abstract class TopArtistsModule {

    @ContributesAndroidInjector(
        modules = [NetworkModule::class]
    )
    abstract fun bindTopArtistsFragment(): TopArtistsFragment

}