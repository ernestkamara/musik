package io.kamara.musik.topartists.di

import dagger.Module
import dagger.Provides
import io.kamara.musik.core.app.ConnectivityChecker
import io.kamara.musik.core.providers.DataMapper
import io.kamara.musik.core.providers.DataProvider

import io.kamara.musik.topartists.entities.Artist
import io.kamara.musik.topartists.entities.TopArtistsState
import io.kamara.musik.topartists.net.LastFmArtists
import io.kamara.musik.topartists.net.LastFmArtistsMapper
import io.kamara.musik.topartists.net.LastFmTopArtistsApi
import io.kamara.musik.topartists.net.LastFmTopArtistsProvider

@Module
object LastFmTopArtistsModule {

    @Provides
    @JvmStatic
    fun providesTopArtistsDataProvider(
        lastFmTopArtistsApi: LastFmTopArtistsApi,
        connectivityChecker: ConnectivityChecker,
        mapper: DataMapper<LastFmArtists, List<Artist>>
    ): DataProvider<TopArtistsState> =
        LastFmTopArtistsProvider(
            lastFmTopArtistsApi,
            connectivityChecker,
            mapper
        )

    @Provides
    @JvmStatic
    fun providesLastFmMapper(): DataMapper<LastFmArtists, List<Artist>> =
        LastFmArtistsMapper()
}