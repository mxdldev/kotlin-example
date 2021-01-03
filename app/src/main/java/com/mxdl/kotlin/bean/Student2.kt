package com.mxdl.kotlin.bean

import com.mxdl.kotlin.test.Person1

/**
 * Description: <Student1><br>
 * Author:      mxdl<br>
 * Date:        2020/12/13<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class Student2 constructor(var sno:String, var grade:Int, name:String, age:Int): Person1(name,age){

        constructor(name: String,age: Int):this("",0,name,age)
        constructor():this("",0)
}