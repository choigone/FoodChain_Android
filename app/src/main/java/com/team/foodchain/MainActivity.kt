package com.team.foodchain

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_login.*
import android.R.id.edit
import android.media.Image
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text
import android.app.Activity
import com.kakao.auth.ISessionCallback
import com.kakao.auth.Session
import com.kakao.util.exception.KakaoException
import com.kakao.util.helper.log.Logger

class MainActivity : AppCompatActivity(), View.OnClickListener {

    internal var callback: SessionCallback? = null

    var userText: EditText? = null
    var pwText: EditText? = null
    var loginButton: ImageButton? = null
    var searchId: TextView? = null
    var searchPw: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login_join_tv.setOnClickListener(this)
        login_eye_btn.setOnClickListener(this)
        login_login_btn.setOnClickListener(this)

        login_login_btn.isSelected = false

        callback = SessionCallback()
        Session.getCurrentSession().addCallback(callback)

        userText = findViewById(R.id.login_id) as EditText
        pwText = findViewById(R.id.login_pwd) as EditText
        loginButton = findViewById(R.id.login_login_btn) as ImageButton
        searchId = findViewById(R.id.login_search_id) as TextView
        searchPw = findViewById(R.id.login_search_pwd) as TextView

        userText!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s1: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s1!!.isEmpty()) {
                    pwText!!.addTextChangedListener(object : TextWatcher {
                        override fun afterTextChanged(s: Editable?) {
                        }
                        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                        }
                        override fun onTextChanged(s2: CharSequence?, start: Int, before: Int, count: Int) {
                            login_login_btn.isSelected = false
                            if (!s2!!.isEmpty()) {
                                login_login_btn.isSelected = true
                                if (s1.isEmpty()) {
                                    login_login_btn.isSelected = false
                                }
                            } else {
                                login_login_btn.isSelected = false
                            }
                        }
                    })
                } else {
                    login_login_btn.isSelected = false
                }
            }
        })


    }


    var isEye = 0
    override fun onClick(v: View?) {
        when (v) {
            login_join_tv -> {
                val intent = Intent(applicationContext, JoinActivity::class.java)
                startActivity(intent)
            }

            login_eye_btn -> {
                if (isEye == 0) {
                    login_eye_btn.isSelected = true
                    login_pwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
                    isEye = 1
                }
                // 다시 안보이게 하는 input type잉 없음????띵이이ㅛㅇㅇ
                else if(isEye == 1){
                    login_eye_btn.isSelected = false
                    login_pwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
                    isEye = 0
                }
            }


        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onDestroy() {
        super.onDestroy()
        Session.getCurrentSession().removeCallback(callback)
    }

    inner class SessionCallback : ISessionCallback {

        override fun onSessionOpened() {
            redirectSignupActivity()  // 세션 연결성공 시 redirectSignupActivity() 호출
        }

        override fun onSessionOpenFailed(exception: KakaoException?) {
            if (exception != null) {
                Logger.e(exception)
            }
            setContentView(R.layout.activity_login) // 세션 연결이 실패했을때
        }                                            // 로그인화면을 다시 불러옴
    }

    protected fun redirectSignupActivity() {

        //세션 연결 성공 시 SignupActivity로 넘김
        val intent = Intent(this, KakaoSignupActivity::class.java)
        // intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent)
        finish()
    }

}
