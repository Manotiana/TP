package com.tp.app.utils

import android.content.Context
import android.widget.Toast
import com.tp.app.data.model.Etudiant

fun Etudiant.initial():String{
    return nom.substring(0,1) + prenom.substring(0,1)
}
fun Context.toast(display:String){
    Toast.makeText(
            this,
            display,
            Toast.LENGTH_LONG
    ).show()
}