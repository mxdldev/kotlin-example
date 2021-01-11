package com.mxdl.kotlin.closure

fun test(): ()->Unit{
    var a = 0
    return fun(){
        a++
        println(a)
    }
}
fun main(args: Array<String>) {
    var t = test()
    t()
    t()
    t()
}