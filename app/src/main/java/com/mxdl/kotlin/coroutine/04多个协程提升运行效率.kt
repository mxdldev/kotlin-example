package com.mxdl.kotlin.coroutine

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Description: <协程提升并发编程运行效率><br>
 * Author:      mxdl<br>
 * Date:        2021/1/10<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */

fun main(args: Array<String>) {
    testThrad()
    //testCoroutine()
}

private fun testCoroutine() {
    runBlocking {
        var start = System.currentTimeMillis()
        coroutineScope {
            repeat(100000) {
                launch {
                    println(".")
                }
            }
        }
        var end = System.currentTimeMillis()
        println(end - start)
    }
}

private fun testThrad() {
    runBlocking {
        var start = System.currentTimeMillis()
        coroutineScope {
            repeat(100000) {
                Thread(Runnable { println(".") }).start()
            }
        }
        var end = System.currentTimeMillis()
        println(end - start)
    }
}
