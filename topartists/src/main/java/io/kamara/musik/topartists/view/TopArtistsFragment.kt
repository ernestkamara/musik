package io.kamara.musik.topartists.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import dagger.android.support.DaggerFragment
import io.kamara.musik.topartists.R
import javax.inject.Inject

class TopArtistsFragment : DaggerFragment() {

    @Inject
    lateinit var testString: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_top_artists, container, false).also {
            it.findViewById<TextView>(R.id.test_text).text = testString
        }
}