package io.kamara.musik.topartists.view

import io.kamara.musik.topartists.entities.Artist

sealed class TopArtistsViewState {

    object InProgress : TopArtistsViewState()

    class ShowTopArtists(val topArtists: List<Artist>) : TopArtistsViewState()

    class ShowError(val message: String) : TopArtistsViewState()
}