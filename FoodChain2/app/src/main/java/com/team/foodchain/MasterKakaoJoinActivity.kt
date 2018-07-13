package com.team.foodchain

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_join.*
import kotlinx.android.synthetic.main.activity_master_join.*

class MasterKakaoJoinActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v){
            master_join_btn -> {
                val intent = Intent(applicationContext, ChoiceActivity::class.java)
                startActivity(intent)
            }
        }
    }

    var pwText : EditText? = null
    var pwCheckText : EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_master_join_kakao)
        master_join_btn.setOnClickListener(this)

        pwText = findViewById(R.id.master_pw_et) as EditText
        pwCheckText = findViewById(R.id.master_pwcheck_et) as EditText

        pwText!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s1: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s1: CharSequence?, start: Int, before: Int, count: Int) {
                pwCheckText!!.addTextChangedListener(object : TextWatcher{
                    override fun afterTextChanged(s2: Editable?) {

                    }

                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    }

                    override fun onTextChanged(s2: CharSequence?, start: Int, before: Int, count: Int) {
                        if(s1!!.toString() == s2!!.toString()){
                            master_pw_check.isSelected = true
                        }
                        else{
                            master_pw_check.isSelected = false
                        }
                    }

                })
            }

        })
    }
}