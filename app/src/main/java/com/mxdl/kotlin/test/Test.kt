package com.mxdl.kotlin.test

fun main(args: Array<String>) {
//    val f = { x: Int, y: Int -> println(1) }
//    var x: Int
//    var f1: (Int, Int) -> Int = { x, y -> x + y }
//    println(f1(1, 2))
//    println(f(1, 2))
//    var f2 = { x: Int, y: Int -> x + y }
//    println(f2(1, 2))

    val f3 = println(1)

    val f4 = { println(1)}
    f4()
}

fun add(x: Int, y: Int, f: (x:Int, y:Int) -> Int) {
    f(x, y)
    f.invoke(x,y)
}