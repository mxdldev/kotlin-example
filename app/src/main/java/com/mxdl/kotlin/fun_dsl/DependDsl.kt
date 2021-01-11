package com.mxdl.kotlin.fun_dsl

/**
 * Description: <DependDsl><br>
 * Author:      mxdl<br>
 * Date:        2020/9/6<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class DependDsl {
    var libs = ArrayList<String>()

    fun implementation(lib: String){
        libs.add(lib)
    }
}
fun dependencies(block: DependDsl.()->Unit): ArrayList<String>{
    var dependDsl = DependDsl()
    dependDsl.block()
    return dependDsl.libs
}
fun main(args: Array<String>) {
    dependencies {
        implementation("github.com:retrofit:1.0")
        implementation("github.com:okhttp:1.1")
    }
}