package io.kamara.musik.core.providers

interface DataProvider<T> {

    fun requestData(callback: (item: T) -> Unit)
}