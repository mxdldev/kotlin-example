package com.mxdl.kotlin.bean

/**
 * Description: <Student1><br>
 * Author:      mxdl<br>
 * Date:        2020/12/13<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class Student2(val name:String, age:Int, val sno:String, val grade:Int){
        init {

        }
        constructor(name: String,age: Int):this("",0,name,age)
        constructor():this("",0)
}