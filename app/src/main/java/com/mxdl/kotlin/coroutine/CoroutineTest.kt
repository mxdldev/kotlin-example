package com.mxdl.kotlin.coroutine

import com.mxdl.kotlin.coroutine.data.Weather
import com.mxdl.kotlin.coroutine.http.RetrofitManager
import com.mxdl.kotlin.coroutine.http.await
import com.mxdl.kotlin.coroutine.service.WeatherService
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Description: <CoroutineTest><br>
 * Author:      mxdl<br>
 * Date:        2020/9/25<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    //1.原生调用
    //getWeather()
    //2.自定义携程调用
    //getWeather1()
    //3.Retrofit携程
    getWeather2()
}

//1.使用Retorfit自带的协程
private fun getWeather2() {
    runBlocking {
        var retrofit = Retrofit.Builder()
            .client(
                OkHttpClient().newBuilder()
//                    .addInterceptor(
//                        HttpLoggingInterceptor()
//                            .setLevel(HttpLoggingInterceptor.Level.BODY)
//                    )
                    .build()
            )
            .baseUrl("https://v0.yiketianqi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        println(Thread.currentThread().name)
        launch {

            //1.获取目前的天气服务
            val weatherService = retrofit.create(WeatherService::class.java)
            //2.获取天气，函数挂起
            val weather = weatherService.getWeather2();
            //3.函数恢复后打印结果
            println(weather)

            //获取空气质量，函数挂起
            var air = weatherService.getAir();
            println(air)
        }
        println("-------------------------------")
        async {
            println(Thread.currentThread().name)
        }
    }
}

//2.使用我们自定义的协程
private fun getWeather1() {
    runBlocking {
        launch {
            val weather = RetrofitManager.retrofit.create(WeatherService::class.java)
                .getWeather()
                .await()
            println(weather)

        }
    }
}

//3.使用协程调用
private fun getWeather() {
    var retrofit = Retrofit.Builder()
        .client(
            OkHttpClient().newBuilder()
                .addInterceptor(
                    HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY)
                )
                .build()
        )
        .baseUrl("https://v0.yiketianqi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service = retrofit.create(WeatherService::class.java)
    service.getWeather().enqueue(object : Callback<Weather> {
        override fun onFailure(call: Call<Weather>, t: Throwable) {
            println("onFail:" + t.toString())
        }

        override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
            println("onResponse:" + response.body())
        }

    })
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