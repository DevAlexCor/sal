package com.github.devalexcor.saldemo

import com.github.devalexcor.salcore.Application

internal class App : Application() {
    override fun onStart() {
        println("onStart")
    }

    override fun onStop() {
        println("onStop")
    }
}