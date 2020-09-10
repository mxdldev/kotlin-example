package com.mxdl.kotlin.util

import android.view.View

/**
 * Description: <Test><br>
 * Author:      mxdl<br>
 * Date:        2020/9/10<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class Test {
}

fun main(args: Array<String>) {
    var list = listOf("a","ab","abc")
    val max = list.map { it.toUpperCase() }.filter { it.length > 1 }.maxBy { it.length }
    println(max)

    val any = list.all { it.length > 0 }
    println("any:$any")

    var thread = Thread(object :Runnable{
        override fun run() {
            TODO("Not yet implemented")
        }
    }).start()

    Thread{
        println("ok")
    }.start()
    var view :View? = null
    view?.setOnClickListener{
        println("ffafaaf")
    }
}