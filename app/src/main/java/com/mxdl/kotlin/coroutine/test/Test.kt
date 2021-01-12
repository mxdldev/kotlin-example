package com.mxdl.kotlin.coroutine.test

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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