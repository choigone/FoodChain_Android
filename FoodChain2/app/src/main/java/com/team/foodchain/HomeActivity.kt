package com.team.foodchain

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.team.foodchain.R.id.*
import kotlinx.android.synthetic.main.activity_page.*

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v){
            page_store_btn -> {
                clearSelected()
                page_store_btn.isSelected = true
                replaceFragment(StoreTab())
            }
            page_ref_btn -> {
                clearSelected()
                page_ref_btn.isSelected = true
                replaceFragment(RefTab())
            }
            page_alarm_btn -> {
                clearSelected()
                page_alarm_btn.isSelected = true
                replaceFragment(AlarmTab())
            }
            page_setting_btn -> {
                clearSelected()
                page_setting_btn.isSelected = true
                replaceFragment(SetTab())
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page)
        addFragment(StoreTab())
        page_store_btn.isSelected = true
        page_store_btn.setOnClickListener(this)
        page_ref_btn.setOnClickListener(this)
        page_alarm_btn.setOnClickListener(this)
        page_setting_btn.setOnClickListener(this)


        val builder = AlertDialog.Builder(this@HomeActivity)

        builder.setMessage("가입하고 우리 동네 상품을 찾아보세요! " +
                "우리 동네를 설정하고 시작하세요!")
        builder.setPositiveButton("우리 동네 설정하고 시작하기") { dialog, which ->
            setContentView(R.layout.activity_address)
//            root_layout.setBackgroundColor(Color.TRANSPARENT)
        }

        builder.setNeutralButton("둘러보기") { dialog, which ->
            setContentView(R.layout.activity_basket)
//            root_layout.setBackgroundColor(Color.TRANSPARENT)
        }

        val dialog: AlertDialog = builder.create()

        dialog.show()




    }

    fun addFragment(fragment : Fragment){
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.add(R.id.main_frame, fragment)
        transaction.commit()
    }

    fun replaceFragment(fragment: Fragment){
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.main_frame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun clearSelected(){
        page_store_btn.isSelected = false
        page_ref_btn.isSelected = false
        page_alarm_btn.isSelected = false
        page_setting_btn.isSelected = false
    }
}