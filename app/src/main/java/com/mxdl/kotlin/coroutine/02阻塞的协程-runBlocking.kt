package com.mxdl.kotlin.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * 1.基本功能演示，特点
 * 2.顶级函数，函数是编程【函数是一等公民】
 */
fun main(args: Array<String>) {
    //1.启动阻塞线程的协程,一般用于测试
    val result = runBlocking {
        println("runBlocking start")
        delay(3000)
        println("runBlocking end")
        1
    }
    println(result)
    println("game over")
}