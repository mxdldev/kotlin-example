package com.mxdl.kotlin.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

fun main(args: Array<String>) {
    //1.启动一个顶级协程,顶级协程维护成本太高
    val job = GlobalScope.launch {
        println("hello world")
    }
    println("game over")
    Thread.sleep(5000)

    Executors.newCachedThreadPool()
}