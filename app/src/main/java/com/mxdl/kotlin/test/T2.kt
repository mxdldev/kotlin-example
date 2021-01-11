package com.mxdl.kotlin.test

/**
 * Description: <T2><br>
 * Author:      mxdl<br>
 * Date:        2020/12/13<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    println(Int.MAX_VALUE)
    println(Int.MIN_VALUE)
    println(Math.pow(2.0,31.0) - 1)
    println(Math.pow(2.0,7.0) - 1)
    println(Math.pow(2.0,31.0))

    var minShort = 0b10000000
    var maxShort = 0b01111111
    var maxShort1 = 0b11111111
    println(minShort)
    println(maxShort)
    println(maxShort1)
    var b = -128

    args.forEach(::print)

}