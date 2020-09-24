package com.mxdl.kotlin.generic

import com.mxdl.kotlin.bean.Person
import com.mxdl.kotlin.bean.Student
import com.mxdl.kotlin.bean.Teacher

/**
 * Description: <TestGeneric><br>
 * Author:      mxdl<br>
 * Date:        2020/9/24<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    var simpleData = SimpleData<Student>(Student("zhangsan",18))
    //simpleData.set(Student("zhangsan",18))
    handleSimpleData(simpleData)

    //为什么泛型的协变，泛型T只能出现在out的位置，举反例
    //我们期望返回的是一个Student对象，而实际上返回确是一个Teacher，势必会造成类型转换异常
    val student = simpleData.get()
}
fun handleSimpleData(simpleData: SimpleData<Person>){
    //simpleData.set(Teacher("lisi",20))
}