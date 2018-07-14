package com.team.foodchain

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_join.*
import kotlinx.android.synthetic.main.activity_login.*

class KakaoJoinActivity : AppCompatActivity(), View.OnClickListener {

//    val inten = Intent(this, UserKakaoJoinActivity::class.java)

    override fun onClick(v: View?) {
        when(v){
            join_user_btn -> {
                redirectMainActivity()
            }
            join_master_btn -> {
                val intent = Intent(applicationContext, MasterKakaoJoinActivity::class.java)
                startActivity(intent)
            }
        }
    }

    lateinit var kakaoID : String
    lateinit  var kakaoNickname : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_kakao)
        join_user_btn.setOnClickListener(this)
        join_master_btn.setOnClickListener(this)

        kakaoID = intent.getStringExtra("kakaoID")
        kakaoNickname = intent.getStringExtra("kakaoNickname")

        Log.e("Profile", kakaoID + kakaoNickname)

    }
    private fun redirectMainActivity() {
        //  startActivity(Intent(this, KakaoJoinActivity::class.java))

        val inten = Intent(this, UserKakaoJoinActivity::class.java)

        inten.putExtra("kakaoID", kakaoID)
        inten.putExtra("kakaoNickname", kakaoNickname)

        startActivity(inten)
        finish()
    }
}