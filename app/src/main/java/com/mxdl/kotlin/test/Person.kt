package com.mxdl.kotlin.test

import kotlinx.coroutines.yield

/**
 * Description: <Person><br>
 * Author:      mxdl<br>
 * Date:        2020/12/13<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class Person{
    var name:String = ""
    var age:Int = 0
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