package com.mxdl.kotlin.coroutine.test

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Description: <`Test``><br>
 * Author:      mxdl<br>
 * Date:        2021/1/10<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class Test1 {}

fun main(args: Array<String>) {
    test()
    //test1()
}

private fun test1() {
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

private fun test() {
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

fun add() {
}