package com.github.devalexcor.salcore

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

object MainScope : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + MainDispatcher
}