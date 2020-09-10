package com.mxdl.kotlin.util

/**
 * Description: <Person><br>
 * Author:      mxdl<br>
 * Date:        2020/9/10<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
data class Person(var name: String = "",var age: Int = 0) {
    fun work(){
        println("start work")
    }
    fun study(){
        println("start study")
    }
}