package com.example.android4homework2.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper {

    private var sharedPreference : SharedPreferences? = null

    fun unit(context: Context){
        sharedPreference = context.getSharedPreferences("settings", Context.MODE_PRIVATE)
    }
    var saveBoolean
        set(value) = sharedPreference?.edit()?.putBoolean("Bool", value!!)?.apply()!!
        get() = sharedPreference?.getBoolean("Bool", false)
}