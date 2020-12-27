package com.mxdl.kotlin

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.TextView
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import org.w3c.dom.Text
import java.io.BufferedReader
import java.lang.StringBuilder
import java.net.URL

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
           var scope = CoroutineScope(Dispatchers.IO+Job())
            scope.launch {
               // var result = test()
                //println("result:$result")
//                launch { test2() }
//                launch { test3() }
                 println(test4())
                 println("launch end")
            }
            println("onClick end")
//            runBlocking {
//                test1()
//            }
        }

        var intent = Intent(baseContext,MainActivity::class.java)
        intent.putExtra("param1","name")
        intent.putExtra("param1",18)
        startActivity(intent)

        startActivty<MainActivity>(baseContext){
            intent.putExtra("param1","name")
            intent.putExtra("param1",18)
        }
    }
    inline fun<reified T> startActivty(contxt:Context,block:Intent.()->Unit){
        var intent = Intent(contxt,T::class.java)
        intent.block()
        contxt.startActivity(intent)
    }
    suspend fun test4():String{
        delay(5000)
        return "test4"
    }
    suspend fun test2(){
        withContext(Dispatchers.IO){
            println(1)
            println(2)
            println(3)
        }

    }
    suspend fun test3(){
        withContext(Dispatchers.IO){
            println(4)
            println(5)
            println(6)
        }
    }
   suspend fun test1(){
       withContext(Dispatchers.IO){
           println("Thread:${Thread.currentThread().name}")
       }
   }
   @RequiresApi(Build.VERSION_CODES.N)
   suspend fun test():String{
        var httpURLConnection = URL("http://www.baidu.com").openConnection()
        httpURLConnection.connect()
        val bufferedReader = httpURLConnection.getInputStream().bufferedReader()
        StringBuilder().apply {
            for(line in bufferedReader.lines()){
                append(line)
            }
        }.let {
            //Log.v("MYTAG","result:${it.toString()}")
            return it.toString()
        }
    }
}