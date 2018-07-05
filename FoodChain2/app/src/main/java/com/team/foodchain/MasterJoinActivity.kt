package com.team.foodchain

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_join.*
import kotlinx.android.synthetic.main.activity_master_join.*

class MasterJoinActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v){
            master_join_btn -> {
                val intent = Intent(applicationContext, ChoiceActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_master_join)
        master_join_btn.setOnClickListener(this)
    }
}