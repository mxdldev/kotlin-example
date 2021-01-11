package com.mxdl.kotlin.coroutine.test.temp

import kotlinx.coroutines.*
import java.lang.Runnable

/**
 * Description: <CoroutineTest1><br>
 * Author:      mxdl<br>
 * Date:        2021/1/9<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun foo(){
   for(i in 1..1000){
       println(i)
   }
}
fun bar(){
    for(i in 1..1000){
        println("$i-------------------------------")
    }
}
suspend fun foo1(){
    for(i in 1..1000){
        println(i)
        delay(1)
    }
}
suspend fun bar1(){
    for(i in 1..1000){
        println("$i-------------------------------")
        delay(1)
    }
}
suspend fun main(args: Array<String>) {
    //test1()
    //test2()
    /*runBlocking {
        delay(1000 * 5)
        println(11)
    }
    println("hello world")*/
    /*val job = GlobalScope.launch {
        println("ok")
    }
    job.join()*/

    main1()
}
fun main1() = runBlocking { // this: CoroutineScope
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
private fun test2() {
    Thread(Runnable {
        foo()
    }).start()
    Thread(Runnable {
        bar()
    }).start()
}

private fun test1() {
    runBlocking {
        launch {
            foo1()

        }
        launch {
            bar1()
        }

    }
}