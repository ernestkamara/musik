package io.kamara.musik

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import io.kamara.musik.topartists.view.TopArtistsFragment

class MusikActivity: DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_fragment, TopArtistsFragment())
            commit()
        }
    }
}