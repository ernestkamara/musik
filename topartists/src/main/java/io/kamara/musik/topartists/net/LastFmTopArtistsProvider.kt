package io.kamara.musik.topartists.net

import io.kamara.musik.core.app.ConnectivityChecker
import io.kamara.musik.core.providers.DataMapper
import io.kamara.musik.core.providers.DataProvider
import io.kamara.musik.topartists.entities.Artist
import io.kamara.musik.topartists.entities.TopArtistsState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LastFmTopArtistsProvider(
    private val topArtistsApi: LastFmTopArtistsApi,
    private val connectivityChecker: ConnectivityChecker,
    private val mapper: DataMapper<LastFmArtists, List<Artist>>
) : DataProvider<TopArtistsState> {

    override fun requestData(callback: (topArtists: TopArtistsState) -> Unit) {
        if (!connectivityChecker.isConnected) {
            callback(TopArtistsState.Error("No network connectivity"))
            return
        }
        callback(TopArtistsState.Loading)
        topArtistsApi.getTopArtists().enqueue(object : Callback<LastFmArtists> {
            override fun onFailure(call: Call<LastFmArtists>, t: Throwable) {
                callback(TopArtistsState.Error(t.localizedMessage))
            }

            override fun onResponse(call: Call<LastFmArtists>, response: Response<LastFmArtists>) {
                response.body()?.also { topArtists ->
                    callback(TopArtistsState.Success(mapper.map(topArtists)))
                }
            }
        })
    }
}