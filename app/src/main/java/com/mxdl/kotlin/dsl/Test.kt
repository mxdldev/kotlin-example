package com.mxdl.kotlin.dsl

import kotlin.concurrent.thread

/**
 * Description: <Test><br>
 * Author:      mxdl<br>
 * Date:        2020/9/15<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    Thread{
        println("ok")

    }
    thread { println("okaa") }

    val string by lazy { "aaa" }

}
