package com.mxdl.kotlin.coroutine

import kotlinx.coroutines.*

fun main(args: Array<String>) {
    //1.使用try-catch可以捕获异常，但是永远不要跨域捕获
    //2.使用CoroutineExceptionHandler可以简化异常捕获
    //3.CoroutineExceptionHandler只能放在顶级协程
    runBlocking {
        val handler = CoroutineExceptionHandler{coroutineContext, throwable ->
            println("error:"+throwable)
        }
        val job = Job()
        val coroutineScope = CoroutineScope(Dispatchers.Main + job + handler)
        coroutineScope.launch {
            delay(1000)
            println("1")
            throw Exception("未知异常")
        }
        coroutineScope.launch {
            delay(1000 * 2)
            println("2")
        }
        coroutineScope.launch {
            delay(1000 * 2)
            println("3")
        }
    }
}