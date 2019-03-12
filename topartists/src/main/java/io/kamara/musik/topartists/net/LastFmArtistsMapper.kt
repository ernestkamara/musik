package io.kamara.musik.topartists.net

import io.kamara.musik.core.providers.DataMapper
import io.kamara.musik.topartists.entities.Artist
import io.kamara.musik.topartists.entities.Artist.ImageSize

class LastFmArtistsMapper : DataMapper<LastFmArtists, List<Artist>> {

    override fun map(source: LastFmArtists): List<Artist> =
        source.artists.artist.map { artist ->
            Artist(artist.name, artist.normalisedImages())
        }

    private fun LastFmArtist.normalisedImages() =
        images.map { it.size.toImageSize() to it.url }.toMap()

    private fun String.toImageSize(): ImageSize =
        when (this) {
            "small" -> ImageSize.SMALL
            "medium" -> ImageSize.MEDIUM
            "large" -> ImageSize.LARGE
            "extralarge" -> ImageSize.EXTRA_LARGE
            else -> ImageSize.UNKNOWN
        }
}