package com.mxdl.kotlin.bean

/**
 * Description: <Student1><br>
 * Author:      mxdl<br>
 * Date:        2021/1/3<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class Student1:Person {
    constructor(name:String,age:Int,gradeno:Int) :super(name, age)
    constructor(name: String,age: Int):this(name,age,0)
}