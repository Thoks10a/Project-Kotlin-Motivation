package com.example.motivation

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {


    private val nameSave: SharedPreferences = context.getSharedPreferences("Motivation",Context.MODE_PRIVATE)

    fun storeString(key: String, str: String){
        nameSave.edit().putString(key,str).apply()
    }

    fun getString(key: String): String{
        return nameSave.getString(key,"") ?: ""
    }
}