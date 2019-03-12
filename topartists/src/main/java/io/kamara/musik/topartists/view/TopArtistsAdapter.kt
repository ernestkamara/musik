package io.kamara.musik.topartists.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import io.kamara.musik.topartists.R
import io.kamara.musik.topartists.entities.Artist
import io.kamara.musik.topartists.entities.Artist.ImageSize

class TopArtistsAdapter(
    private val items: MutableList<Artist> = mutableListOf()
) : RecyclerView.Adapter<TopArtistsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopArtistsViewHolder =
        TopArtistsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_top_artist, parent, false)
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: TopArtistsViewHolder, position: Int) {
        items[position].also { artist ->
            holder.bind(
                rank = (position + 1).toString(),
                artistName = artist.name,
                artistImageUrl = artist.images[ImageSize.MEDIUM] ?: artist.images.values.first()
            )
        }
    }

    fun replace(artists: List<Artist>) {
        val difference = DiffUtil.calculateDiff(TopArtistsDiffUtil(items, artists))
        items.clear()
        items += artists
        difference.dispatchUpdatesTo(this)
    }

}