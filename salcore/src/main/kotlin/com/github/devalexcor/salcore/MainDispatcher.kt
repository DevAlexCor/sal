package com.github.devalexcor.salcore

import kotlinx.coroutines.MainCoroutineDispatcher
import kotlinx.coroutines.Runnable
import kotlin.coroutines.CoroutineContext

object MainDispatcher : MainCoroutineDispatcher() {
    override val immediate: MainCoroutineDispatcher
        get() = this

    override fun dispatch(context: CoroutineContext, block: Runnable) {
        MainExecutor.execute(block)
    }
}