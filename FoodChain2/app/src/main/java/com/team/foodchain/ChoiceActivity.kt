package com.team.foodchain

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_choice.*

class ChoiceActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v){
            choice_confirm_tv -> {
                val intent = Intent(applicationContext, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)
        choice_confirm_tv.setOnClickListener(this)
    }
}