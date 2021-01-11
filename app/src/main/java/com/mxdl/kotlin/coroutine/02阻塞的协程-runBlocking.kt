package com.mxdl.kotlin.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    //1.启动阻塞线程的协程,一般用于测试
    runBlocking {
        println("hello world")
        delay(4000)
        println("hello world 1")
    }
    println("game over")
}