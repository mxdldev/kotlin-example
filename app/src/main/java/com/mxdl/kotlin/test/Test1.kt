package com.mxdl.kotlin.test

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main(args: Array<String>) {
    GlobalScope.launch {
        println("hello world")
    }
    println("main game over")
    Thread.sleep(1000 * 5)
}