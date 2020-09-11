package com.mxdl.kotlin.util

/**
 * Description: <扩展函数><br>
 * Author:      mxdl<br>
 * Date:        2020/9/11<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
//给String类添加一个扩展函数，用来计算字符串中字母的个数
fun String.lettersCount(): Int{
    var count = 0
    for(char in this){
        if(char.isLetter()){
            count++
        }
    }
    return count
}
fun main(args: Array<String>) {
    val count = "l1a132s;234af".lettersCount()
    println("count:$count")
}