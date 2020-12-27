package com.mxdl.kotlin.test

/**
 * Description: <Person><br>
 * Author:      mxdl<br>
 * Date:        2020/12/13<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
open class Person1 constructor(var name:String,var age:Int){
    fun eat(){
        println(name+" is eating.he is "+age+" years old")
    }
}

fun main(args: Array<String>) {
    var person = Person()
    person.name = "Jack"
    person.age = 18
    person.eat()
}