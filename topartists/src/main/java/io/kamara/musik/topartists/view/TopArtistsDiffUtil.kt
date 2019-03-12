package io.kamara.musik.topartists.view

import androidx.recyclerview.widget.DiffUtil
import io.kamara.musik.topartists.entities.Artist

class TopArtistsDiffUtil(
    private val oldList: List<Artist>,
    private val newList: List<Artist>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] === newList[newItemPosition]

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].name == newList[newItemPosition].name
}
