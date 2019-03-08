package io.kamara.musik.core.providers

interface DataMapper<S, R> {
    fun map(source: S): R
}