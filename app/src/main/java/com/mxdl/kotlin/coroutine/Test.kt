package com.mxdl.kotlin.coroutine

import kotlinx.coroutines.*

fun main(args: Array<String>) {
    runBlocking {
        launch {
            for (i in 1..100) {
                println("for $i")
                delay(1000)
            }
        }
        launch {
            for (i in 1..100) {
                println("lan $i")
                delay(1000)
            }
        }
    }

}

suspend fun foo() {
    delay(1000 * 3)
    coroutineScope {
        launch { }
    }
    println("foo start")
}
suspend fun bar(){
    coroutineScope {
        launch {

        }
    }
}