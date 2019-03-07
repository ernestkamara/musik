package io.kamara.musik

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.kamara.musik.di.DaggerApplicationComponent


class MusikApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerApplicationComponent.builder().create(this)
}