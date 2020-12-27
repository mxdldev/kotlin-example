package com.mxdl.kotlin.test

/**
 * Description: <T2><br>
 * Author:      mxdl<br>
 * Date:        2020/12/13<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
object T2 {
    var age = 0
    fun checkNumber(num:Number){
        when(num){
            is Int -> println("num is int")
            is Double -> println("num is double")
            else  -> println("number is not support")
        }
    }
}

fun main(args: Array<String>) {
    var d:Double = 1231.33
    var c:Float = 1231.33f
    T2.checkNumber(1)
}