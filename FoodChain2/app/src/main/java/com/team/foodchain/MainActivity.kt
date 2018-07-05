package com.team.foodchain

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_login.*
import android.R.id.edit
import android.media.Image
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

//id password null값이면 활성화 되도록 짰는데 계속 활성화 됨....ㅅㅂ

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var userText : EditText? = null
    var pwText : EditText? = null
    var loginButton : ImageButton? = null
    var searchId : TextView? = null
    var searchPw : TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login_join_tv.setOnClickListener(this)

        login_login_btn.isSelected = false

        userText = findViewById(R.id.login_id) as EditText
        pwText = findViewById(R.id.login_pwd) as EditText
        loginButton = findViewById(R.id.login_login_btn) as ImageButton
        searchId = findViewById(R.id.login_search_id) as TextView
        searchPw = findViewById(R.id.login_search_pwd) as TextView

        val strUser = userText!!.text.toString()
        val strPw = pwText!!.text.toString()


        if(strUser != null && strPw!=null){
            login_login_btn.isSelected = true
        }

    }

    override fun onClick(v: View?) {
        when(v){
            login_join_tv -> {
                val intent = Intent(applicationContext, JoinActivity::class.java)
                startActivity(intent)
            }
            /*login_eye_btn -> {
                login_eye_btn.isSelected = true
                login_pwd.inputType =
            }*/
        }
    }
}
