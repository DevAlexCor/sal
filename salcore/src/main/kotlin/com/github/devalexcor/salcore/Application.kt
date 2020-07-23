package com.github.devalexcor.salcore


abstract class Application {
    @Throws(InterruptedException::class)
    fun run() {
        onStart()
        Runtime.getRuntime().addShutdownHook(Thread { onStop() })
        MainExecutor.runLoop()
    }

    protected abstract fun onStart()
    protected abstract fun onStop()
}
