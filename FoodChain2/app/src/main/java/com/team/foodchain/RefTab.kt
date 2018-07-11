package com.team.foodchain

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_page.*
import kotlinx.android.synthetic.main.fragment_my_ref.*


class RefTab : Fragment(), View.OnClickListener{
    override fun onClick(v: View?) {
        when(v){
            user_ref_add_btn -> {

            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater!!.inflate(R.layout.fragment_my_ref, container, false)
        return v
    }
}