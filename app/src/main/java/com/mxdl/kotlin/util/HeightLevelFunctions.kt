package com.mxdl.kotlin.util

import java.lang.StringBuilder

/**
 * Description: <HeightLevelFunction><br>
 * Author:      mxdl<br>
 * Date:        2020/9/11<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun num1AndNum21(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    return operation(num1, num2)
}

fun main(args: Array<String>) {
    //2.lambda表示调用
    val result3 = num1AndNum21(1, 2) { n1, n2 -> n1 + n2 }
    println("result3:$result3")
}