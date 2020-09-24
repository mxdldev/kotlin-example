package com.mxdl.kotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.TextView
import com.mxdl.kotlin.util.*
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val kClass = MainActivity::class

        var list = ArrayList<Int>()
        var l :List<Int>
        MainActivity::class.java
        var intent = Intent(this,MainActivity::class.java)
//        txtName.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(p0: Editable?) {
//            }
//
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                Log.v("MYTAG", "text:" + p0)
//            }
//
//        })
        txtName.addMyTextChangeListener(onTextChanged = { charSequence, i, i2, i3 -> Log.v("MYTAG", "text:$charSequence")})

        txtName.addTextChenageListenerDsl {
            onTextChanged { charSequence, i, i2, i3 -> Log.v("MYTAG", "text1:$charSequence")}
        }

        var libs = dependencies {
            implementation("com.spuare.okhttp")
            implementation("com.spuare.retrofit")
        }
        for(lib in libs){
            Log.v("MYTAG","lib:$lib")
        }

        getSharedPreferences("data", Context.MODE_PRIVATE)
            .open {
                putString("key1","a")
                putString("key2","b")
            }

        "show".showToast(this)
    }
}