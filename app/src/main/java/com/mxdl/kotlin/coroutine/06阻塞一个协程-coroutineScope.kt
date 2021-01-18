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
        }
        println("coroutineScope end")
    }
    println("runBlocking end")
}
private fun test1(){
    runBlocking { // this: CoroutineScope
        launch {
            delay(200L)
            println("task from runBlocking")
        }

        coroutineScope { // 创建一个协程作用域
            launch {
                delay(500L)
                println("task form launch")
            }

            delay(100L)
            println("task from coroutineScope") // 这一行会在内嵌 launch 之前输出
        }

        println("coroutineScope end") // 这一行在内嵌 launch 执行完毕后才输出
    }
}
