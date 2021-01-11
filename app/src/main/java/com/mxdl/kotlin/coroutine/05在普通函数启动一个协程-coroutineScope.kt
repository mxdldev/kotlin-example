package com.mxdl.kotlin.coroutine

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    //1.suspend挂起函数
    //2.通过coroutineScope给任意函数添加协程作用域
    runBlocking {
        printDot()
        printDot1()
    }
}
fun printDot1(){

}
suspend fun printDot(){
    coroutineScope {
        launch {
            println(".")
        }
    }
}

