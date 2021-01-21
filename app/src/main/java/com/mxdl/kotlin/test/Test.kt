package com.mxdl.kotlin.test

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main(args: Array<String>) {
    runBlocking {
        val result = request()
        println(result)
    }

    println("main game over")

}

//进行一个耗时的操作
//1.网络交互
//2.IO操作
suspend fun request(): String {
    return withContext(Dispatchers.IO) {
        "result"
    }
}
