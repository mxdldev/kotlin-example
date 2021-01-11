package com.mxdl.kotlin.coroutine

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    //1.async会启动一个协程并返回一个deffered的结果
    //2.调用deffered的await方法获取执行结果
    //3.async函数调用后起作用域中的代码会立即执行
    //4.await函数执行后如果结果没有返回则会一直阻塞该协程，直到结果返回
    runBlocking {
        val start = System.currentTimeMillis()
        val result = async {
            delay(1000 * 3)
            1 + 1
        }.await()
        //阻塞开始
        println(result)
        val result1 = async {
            delay(1000 * 2)
            2 + 2
        }.await()
        //阻塞开始
        println(result1)
        val end = System.currentTimeMillis()
        println(end - start)
    }
}