package io.kamara.musik.topartists.di

import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun testString() = "Hello World! This is cool"

}