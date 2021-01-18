package com.mxdl.kotlin.coroutine

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

/**
 * 1.基本使用，添加依赖，特点，源码解析
 * 2.object关键字讲解
 * 2.1 声明对象
 * 2.2 半生对象
 * 2.3 对象表达式
 */
fun main(args: Array<String>) {
    //1.启动一个顶级协程,顶级协程维护成本太高
    val job = GlobalScope.launch{
        println("hello world")
    }
    println("game over")
    Thread.sleep(5000)
}