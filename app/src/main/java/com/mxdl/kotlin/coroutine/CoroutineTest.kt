package com.mxdl.kotlin.coroutine

import kotlinx.coroutines.*
import java.io.BufferedReader
import java.net.HttpURLConnection
import java.net.URL

/**
 * Description: <CoroutineTest><br>
 * Author:      mxdl<br>
 * Date:        2020/9/25<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun test() {
    var coroutineScope = CoroutineScope(Job())
    //println("test start...")
    coroutineScope.launch {
        println("launch start...")
        val result = testSuspend()
        println("result:$result")
        println("launch end...")
    }
    //println("test end...")
}

suspend fun testSuspend(): String {
    return withContext(Dispatchers.IO) {
//        var connection = URL("http://www.baidu.com").openConnection() as HttpURLConnection
//        connection.connect()
//        var result = connection.inputStream.bufferedReader().use(BufferedReader::readText)
        "abc"
    }
}

fun main(args: Array<String>) {
    test()
}