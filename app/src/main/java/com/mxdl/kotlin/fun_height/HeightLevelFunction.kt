package com.mxdl.kotlin.fun_height

import java.lang.StringBuilder

/**
 * Description: <HeightLevelFunction><br>
 * Author:      mxdl<br>
 * Date:        2020/9/11<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    return operation(num1, num2)
}

fun plus(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun minus(num1: Int, num2: Int): Int {
    return num1 - num2
}

//给StringBuilder实现一个高阶函数
fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
    block()
    return this
}

fun main(args: Array<String>) {
    //1.传统方式调用
    val result = num1AndNum2(1, 2, ::plus)
    println("result:$result")

    val result1 = num1AndNum2(1, 2, ::minus)
    println("result1:$result1")

    //2.lambda表示调用
    val result3 = num1AndNum2(1, 2) { n1, n2 -> n1 + n2 }
    println("result3:$result3")

    val fruits = listOf("apple","banana","pear","orange","grape")
    var stringBuilder = StringBuilder().build {
        append("Start eat fruits").append("\n")
        for(fruit in fruits){
            append("$fruit").append("\n")
        }
        append("Eat all fruits ")
    }
    println("result:${stringBuilder.toString()}")
}