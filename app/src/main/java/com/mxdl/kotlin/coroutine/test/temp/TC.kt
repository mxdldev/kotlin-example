package com.mxdl.kotlin.coroutine.test.temp

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Description: <TC><br>
 * Author:      mxdl<br>
 * Date:        2021/1/9<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    test1()
    //test2()
}

private fun test2() {
    runBlocking {
        val start = System.currentTimeMillis()
        coroutineScope {
            repeat(1000) {
                launch {
                    println(".")
                }
            }
        }
        val end = System.currentTimeMillis()
        println(end - start)
    }
}

private fun test1() {
    val start = System.currentTimeMillis()
    runBlocking {
        repeat(1000) {
            Thread(Runnable {
                println(".")
            }).start()
        }
    }
    val end = System.currentTimeMillis()
    println(end - start)
}