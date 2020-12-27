package com.mxdl.kotlin.fun_extend

import android.content.Context
import android.widget.Toast

/**
 * Description: <ToastTest><br>
 * Author:      mxdl<br>
 * Date:        2020/9/11<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun String.showToast(context: Context,duration: Int = Toast.LENGTH_LONG){
    Toast.makeText(context,this,duration).show()
}