package com.mxdl.kotlin

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.mxdl.kotlin.fun_edit_text.TextWatcherEmpty
import com.mxdl.kotlin.fun_edit_text.addTextChangeListenerLeval
import com.mxdl.kotlin.fun_edit_text.addTextChenageListenerDsl
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.lang.StringBuilder
import java.net.URL

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var intent = Intent(baseContext, MainActivity::class.java)
        intent.putExtra("param1", "name")
        intent.putExtra("param1", 18)
        startActivity(intent)

        startActivty<MainActivity>(baseContext) {
            intent.putExtra("param1", "name")
            intent.putExtra("param1", 18)
        }
        var textView = TextView(baseContext)
        textView.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                TODO("Not yet implemented")
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

        })
        textView.addTextChangedListener(object : TextWatcherEmpty() {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                print("文字修改为：$s")
            }
        })
        textView.addTextChangeListenerLeval(onTextChanged = { p0, p1, p2, p3 -> println() })
        textView.addTextChenageListenerDsl {
            onTextChanged { charSequence, i, i2, i3 ->

            }
        }
    }
}

inline fun <reified T> startActivty(contxt: Context, block: Intent.() -> Unit) {
    var intent = Intent(contxt, T::class.java)
    intent.block()
    contxt.startActivity(intent)
}
