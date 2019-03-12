package io.kamara.musik.topartists.di


import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import io.kamara.musik.core.di.BaseViewModule
import io.kamara.musik.core.di.ViewModelKey
import io.kamara.musik.topartists.view.TopArtistsFragment
import io.kamara.musik.topartists.view.TopArtistsViewModel

@Module(
    includes = [
        NetworkModule::class,
        BaseViewModule::class,
        LastFmTopArtistsModule::class
    ]
)
@Suppress("unused")
abstract class TopArtistsModule {

    @ContributesAndroidInjector
    abstract fun bindTopArtistsFragment(): TopArtistsFragment

    @Binds
    @IntoMap
    @ViewModelKey(TopArtistsViewModel::class)
    abstract fun bindChartsViewModel(viewModel: TopArtistsViewModel): ViewModel
}