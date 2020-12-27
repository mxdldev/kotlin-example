package com.mxdl.kotlin.test

/**
 * Description: <Student2><br>
 * Author:      mxdl<br>
 * Date:        2020/12/13<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class Student2 :Person1 {
    constructor(sno:String, grade:Int, name: String, age:Int) : super(name, age)
    fun m(){
        println(sno)
    }

}

fun main(args: Array<String>) {
    var student2 = Student2("a123",3,"Jack",18)
    println(student2.toString())
}