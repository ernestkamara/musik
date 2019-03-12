package io.kamara.musik.topartists.entities

sealed class TopArtistsState {

    object Loading : TopArtistsState()

    class Success(val artists: List<Artist>) : TopArtistsState()

    class Error(val message: String) : TopArtistsState()
}