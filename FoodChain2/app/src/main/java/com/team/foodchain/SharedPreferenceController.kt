package com.team.android

import android.content.Context

object SharedPreferenceController {
    private val USER = "user"
    private val ID = "id"
    private val PWD = "pwd"

    fun setId(context : Context, id : String){
        val pref = context.getSharedPreferences(USER, Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString(ID, id)
        editor.commit()
    }

    fun getId(context : Context) : String{
        val pref = context.getSharedPreferences(USER, Context.MODE_PRIVATE)
        return pref.getString(ID, "")
    }

    fun setPwd(context : Context, pwd : String){
        val pref = context.getSharedPreferences(USER, Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString(PWD, pwd)
        editor.commit()
    }

    fun getPwd(context : Context) : String{
        val pref = context.getSharedPreferences(USER, Context.MODE_PRIVATE)
        return pref.getString(PWD, "")
    }

    fun clearSPC(context : Context){
        val pref = context.getSharedPreferences(USER, Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.clear()
        editor.commit()
        //SharedPreference에 저장된 데이터 정리
    }

}