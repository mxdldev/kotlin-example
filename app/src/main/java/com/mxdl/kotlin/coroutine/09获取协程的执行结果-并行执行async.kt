package com.mxdl.kotlin.coroutine

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    //1.根据await方法调用的位置不同可实现不同执行结果：串行执行，并行执行
    runBlocking {
        val start = System.currentTimeMillis()
        val deferred1 = async {
            delay(1000 * 3)
            1 + 1
        }
        val deferred2 = async {
            delay(1000 * 2)
            2 + 2
        }
        println(deferred1.await() + deferred2.await())
        val end = System.currentTimeMillis()
        println(end - start)
    }
}