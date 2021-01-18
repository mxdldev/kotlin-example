package com.mxdl.kotlin.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
//1.概念，允许单线程模式下模拟多线程的并发运行效果，程序运行过程中的恢复和挂起完全是由编程语言控制的，和操作系统无关
//2.重点演示由编程语言控制这个点
fun main(args: Array<String>) {
    //1.launch启动多个协程，让谁运行，让谁挂起完全有编程语言控制
    runBlocking {
       val job1 =  launch {
            println("luncher1 start")
            delay(1000)
            println("luncher1 end")
        }
        val job2 = launch {
            println("luncher2 start")
            delay(1000)
            println("luncher2 end")
        }
    }
    println("game over")
}