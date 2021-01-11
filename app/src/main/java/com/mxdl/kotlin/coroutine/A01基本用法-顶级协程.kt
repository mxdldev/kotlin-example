package com.mxdl.kotlin.coroutine

import kotlinx.coroutines.*

/**
 * Description: <协程的基本用法><br>
 * Author:      mxdl<br>
 * Date:        2020/9/25<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */

//5.CoroutineScope函数的使用
fun test4() {
    val coroutineScope = CoroutineScope(Job())
    coroutineScope.launch {
        println("hello world")
    }
}

//4.coroutineScope函数的使用
suspend fun test3() {
    println("test")
    coroutineScope {
        println("test1")
    }
}

//3.launch函数的使用
private fun test2() {
    runBlocking {
        //delay(5000)
        launch {
            delay(1000)
            println("launch1")

        }
        launch {
            println("launch2")
        }
    }
}

//2.创建一个阻塞线程的协程
private fun test1() {
    runBlocking {
        println("hello world")
    }
    println("end")
}

//1.创建一个顶级携程
private fun test() {
    val job = GlobalScope.launch {
        println("hello world")
    }
}

private fun test5(){
    runBlocking { // this: CoroutineScope
        launch {
            delay(200L)
            println("Task from runBlocking")
        }

        coroutineScope { // 创建一个协程作用域
            launch {
                delay(500L)
                println("Task from nested launch")
            }

            delay(100L)
            println("Task from coroutine scope") // 这一行会在内嵌 launch 之前输出
        }

        println("Coroutine scope is over") // 这一行在内嵌 launch 执行完毕后才输出
    }
}