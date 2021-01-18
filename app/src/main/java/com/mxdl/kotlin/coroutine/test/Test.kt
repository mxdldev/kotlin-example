package com.mxdl.kotlin.coroutine.test

import kotlinx.coroutines.*

fun main(args: Array<String>) {
    runBlocking {
        val job  = launch {
            delay(1000 * 3)
            println(1)
        }
        job.join()
        launch {
            println(2)
        }
    }
}