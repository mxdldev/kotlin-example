package com.mxdl.kotlin.util

import android.content.Intent
import java.lang.StringBuilder

/**
 * Description: <Stand><br>
 * Author:      mxdl<br>
 * Date:        2020/9/10<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */

//1. let调用链的结果上执行一个或多个操作
fun testLet1(){
    //创建一个集合
    var numbers = mutableListOf("one","two","three","four","five")
    //集合过滤并且打印
    numbers.map { it.length }.filter { it > 3 }.let { println(it) }
}

//2. let简化对象的非空判断
fun testLet2(){
    var person = Person("Jim",18)
    person?.let {
        it.work()
        it.study()
    }
}

//3. let 对it重命名提高代码的阅读性
fun testLet3(){
    //创建一个集合
    var numbers = mutableListOf("one","two","three","four","five")
    var result = numbers.first().let {
        firstItem ->
        if(firstItem.length > 5) firstItem else "$firstItem 1"
    }
    println("result:"+result)
}
//==================================================================
//run 调用对象的一组函数
fun testRun1(){
    var numbers = mutableListOf("one","two","three","four","five")
    var result = StringBuilder().run {
        append("start...").append("\n")
        for(item in numbers){
            append(item).append("\n")
        }
        append("end...").append("\n")
        toString()
    }
    println("result:$result")
}
// with调用对象的一组函数
fun testWith(){
    var numbers = mutableListOf("one","two","three","four","five")
    var result = with(StringBuilder()){
        append("start...").append("\n")
        for(item in numbers){
            append(item).append("\n")
        }
        append("end...").append("\n")
        toString()
    }
    println("result:$result")
}
//==================================================================
//apply 配置对象的属性，配置完毕返回对象本身
fun testApply(){
    var person = Person()
    person = person.apply {
        name = "Jake"
        age = 18
    }
    println("person:$person")
    //Intent对象的配置
    var intent = Intent().apply {
        putExtra("parm1","data1")
        putExtra("parm2","data2")
    }

}
//==================================================================
//also 对该对象执行一个附加操作，并返回对象本身
fun testAlso(){
    var numbers = mutableListOf("one","two","three","four","five")
     numbers.also {
         //附加一个打印的操作
        println("it:$it")
    }.add("six")

    println("numbers:$numbers")
}
//==================================================================
fun main(args: Array<String>) {
    testLet1()
    testLet2()
    testLet3()

    testRun1()

    testWith()

    testApply()

    testAlso()
}