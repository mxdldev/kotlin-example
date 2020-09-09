package com.mxdl.kotlin.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView

/**
 * Description: <TextViewUtil><br>
 * Author:      mxdl<br>
 * Date:        2020/9/6<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */

inline fun TextView.addMyTextChangeListener(crossinline afterTextChanged:(Editable?) -> Unit = {p0 ->}, crossinline beforeTextChanged:(CharSequence?,Int,Int,Int) -> Unit = {p0, p1, p2, p3 -> },
                                            crossinline onTextChanged:(CharSequence?, Int, Int, Int) -> Unit = { p0, p1, p2, p3 -> }):Unit{
    addTextChangedListener(object : TextWatcher{
        override fun afterTextChanged(p0: Editable?) {
            afterTextChanged.invoke(p0)
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            beforeTextChanged.invoke(p0, p1, p2, p3)
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            onTextChanged.invoke(p0, p1, p2, p3)
        }

    })

}

inline fun TextView.addMyTextChangeListener1(crossinline afterTextChanged:(Editable?) -> Unit = {p0 ->}, crossinline beforeTextChanged:(CharSequence?,Int,Int,Int) -> Unit = {p0, p1, p2, p3 -> },
                                            crossinline onTextChanged:(CharSequence?, Int, Int, Int) -> Unit = { p0, p1, p2, p3 -> }):Unit{
    addTextChangedListener(object : TextWatcher{
        override fun afterTextChanged(p0: Editable?) {
            afterTextChanged.invoke(p0)
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            beforeTextChanged.invoke(p0, p1, p2, p3)
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            onTextChanged.invoke(p0, p1, p2, p3)
        }

    })

}