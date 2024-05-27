package com.devbrunini.motivation.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context ) {

    private val security: SharedPreferences = context.getSharedPreferences("NAME", Context.MODE_PRIVATE)

    @SuppressLint("CommitPrefEdits")
    fun storeString(key: String,str: String){
        security.edit().putString(key,str).apply()
    }

    fun getString(key: String): String{
        return security.getString(key, "") ?: ""
    }

}