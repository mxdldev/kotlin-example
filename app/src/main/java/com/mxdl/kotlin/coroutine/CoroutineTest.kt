package com.mxdl.kotlin.coroutine

import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.http.GET

/**
 * Description: <CoroutineTest><br>
 * Author:      mxdl<br>
 * Date:        2020/9/25<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    //test()
    //Thread.sleep(100)
    //test1()
    //test4()
    //Thread.sleep(1000)

    runBlocking {
        //自定义携程支持
        delay(1000 * 4)
        val result = RetrofitManager.create<WeatherService>().getWeather().await()

        //系统自带的携程支持
        //val result = RetrofitManager.create<WeatherService>().getWeather1()
        println("result:${result}")
    }
}

interface WeatherService {
    @GET("?version=v9&appid=23035354&appsecret=8YvlPNrz=city=北京")
    fun getWeather(): Call<Error>

    @GET("?version=v9&appid=23035354&appsecret=8YvlPNrz=city=北京")
    suspend fun getWeather1(): Error

}

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