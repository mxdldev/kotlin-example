package com.mxdl.kotlin.coroutine

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    //2.通过coroutineScope给任意函数添加协程作用域,另外他可以阻塞当前协程
    //runBlocking阻塞的线程
    //coroutineScope阻塞的是协程
    runBlocking {
        coroutineScope {
            launch {
                for (i in 0..10) {
                    println(i)
                    delay(1000)
                }
            }
            //println("launch end")
        }
        println("coroutineScope finish")
    }
    println("runBlocking finish")
}

