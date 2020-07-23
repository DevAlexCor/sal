package com.github.devalexcor.salcore

import java.util.concurrent.Executor
import java.util.concurrent.LinkedBlockingQueue

internal object MainExecutor : Executor {
    private val tasks = LinkedBlockingQueue<Runnable>()

    @Throws(InterruptedException::class)
    fun runLoop() {
        while (!Thread.interrupted()) {
            tasks.take().run()
        }
    }

    override fun execute(command: Runnable) {
        tasks.add(command)
    }
}
