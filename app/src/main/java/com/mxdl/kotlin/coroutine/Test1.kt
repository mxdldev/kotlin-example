package com.mxdl.kotlin.coroutine

import kotlinx.coroutines.*

fun main(args: Array<String>) {
    //corontineTest()
    threadTest()
}

private fun threadTest() {
    var start = System.currentTimeMillis()
    runBlocking {
        repeat(100_000) {
            Thread {
                //Thread.sleep(1000)
                println(".")
            }.start()
        }
    }
    var end = System.currentTimeMillis()
    println(end - start)
}

private fun corontineTest() {
    runBlocking {
        var start = System.currentTimeMillis()
        coroutineScope {
            repeat(100_000) {
                launch {
                    //delay(1000)
                    println(".")
                }
            }
        }
        var end = System.currentTimeMillis()
        println(end - start)
    }
}