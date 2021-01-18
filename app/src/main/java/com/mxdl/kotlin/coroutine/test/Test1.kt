package com.mxdl.kotlin.coroutine.test

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * Description: <Test1><br>
 * Author:      mxdl<br>
 * Date:        2021/1/17<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    runBlocking {
        launch {
            request()
        }
    }
}
suspend fun request(){
    //1.这是一个耗时操作
    withContext(Dispatchers.IO){

    }
}