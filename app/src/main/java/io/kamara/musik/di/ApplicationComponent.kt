package io.kamara.musik.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import io.kamara.musik.MusikApplication
import io.kamara.musik.topartists.di.TopArtistsModule

@Component(
    modules =  [
        AndroidInjectionModule::class,
        ApplicationModule::class,
        ActivityModule::class,
        TopArtistsModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<MusikApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MusikApplication>()
}