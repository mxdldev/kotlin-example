package com.mxdl.kotlin.generic

import com.mxdl.kotlin.bean.Person
import com.mxdl.kotlin.bean.Student
import com.mxdl.kotlin.bean.Teacher

/**
 * Description: <TestTransformer><br>
 * Author:      mxdl<br>
 * Date:        2020/9/24<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    var transformer = object : Transformer<Person>{
        override fun transform(t: Person): String {
            return t.name + t.age
        }

//        override fun transform(name: String, age: Int): Person {
//            return Teacher(name,age)
//        }
    }
    handleTransformer(transformer)
}
fun handleTransformer(transformer: Transformer<Student>){
    //此时我们期待返回的是一个Student对象，而实际上返回的是一个Teacher对象
    //val student = transformer.transform("lisi", 18)
    val result = transformer.transform(Student("lisi", 18))
    println("result:$result")
}