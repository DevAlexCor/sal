# Library for creating a background Kotlin application or a daemon
[![](https://jitpack.io/v/DevAlexCor/sal.svg)](https://jitpack.io/#DevAlexCor/sal)

## How to use it?
Declare a new class which inherits the `Application` class from the library:
```kotlin
class App : Application() {
    /** This method invokes when the application starts */
    override fun onStart() {
        // Your code here
    }

    /** This method invokes when the application stops */
    override fun onStop() {
        // Your code here
    }
}
```
Instantiate the `App` class and invoke `run()` in the main function:
```kotlin
fun main() {
    App().run()
}
```
**Notice:** The `run()` function blocks the current thread, so don't put any code after it, the code won't be executed.

### Coroutines
The library includes `MainScope` and `MainDispatcher` for the application to run coroutines on the main thread:
```kotlin
class App : Application() {
    override fun onStart() {
        MainScope.launch {
            while (true) {
                println("Hello")
                delay(1000)
            }
        }
        MainScope.launch {
            while (true) {
                println("world!")
                delay(1000)
            }
        }
    }

    override fun onStop() {
    }
}
```
To learn more about coroutines take a look at [this documentation](https://kotlinlang.org/docs/reference/coroutines-overview.html).

## Adding the library to your project
Add JitPack in your root build.gradle at the end of repositories:
```groovy
allprojects {
    repositories {
        //...
        maven { url 'https://jitpack.io' }
    }
}
```
Add the dependencies:
```groovy
dependencies {
    implementation 'com.github.devalexcor.sal:salcore:0.0.1-alpha' // update the version to the latest if needed

    // OPTIONAL Add this if you want to use coroutines
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.8' // update the version to the latest if needed
}
```
**Tip:** You can add `application` plugin to your build.gradle. 
```groovy
apply plugin: 'application'
mainClassName = 'com.github.devalexcor.bgapp.MainKt' //replace with yours
```
That allow you to generate a distribution archive for your app by simply running `assembleDist` task. 
Path to the archive will be `build/distributions/`.

## MIT License
Copyright (c) 2020 Alex Cor

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.