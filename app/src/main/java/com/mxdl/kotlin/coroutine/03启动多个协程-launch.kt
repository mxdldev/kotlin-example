package com.mxdl.kotlin.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    //1.launch启动多个协程，让谁运行，让谁挂起完全有编程语言控制
    runBlocking {
        launch {
            println("luncher1 start")
            delay(1000)
            println("luncher1 end")
        }
        launch {
            println("luncher2 start")
            delay(1000)
            println("luncher2 end")
        }
    }
    println("game over")
}