package com.mxdl.kotlin.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main(args: Array<String>) {
    //1.withContext和asyc实现的功能是差不多的
    //2.不过withContext可以指定协程中代码所在执行的线程
    //3.Dispatchers.IO:高并发；Dispatchers.Default低并发;Dispatchers.Main:UI线程
    runBlocking {
        val result = withContext(Dispatchers.IO) {
            delay(1000 * 5)
            println(Thread.currentThread().name)
            1 + 1
        }
        println(result)
        println("ok")
    }
    println("main:" + Thread.currentThread().name)
}