package com.mxdl.kotlin.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main(args: Array<String>) {
    //1.CoroutineScope下创建的所有协程都被关联在job这个任务上
    //2.正式项目里面都会用CoroutineScope
    val job = Job()
    var coroutineScope = CoroutineScope(job)
    coroutineScope.launch {
        delay(1000 * 3)
        println("hello world")
    }
    //job.cancel()
    println("...")
    Thread.sleep(1000 * 5)
}