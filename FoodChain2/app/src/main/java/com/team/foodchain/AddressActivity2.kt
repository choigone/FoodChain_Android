package com.team.foodchain

import android.Manifest
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityCompat.requestPermissions
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_address.*
import kotlinx.android.synthetic.main.activity_address2.*
import kotlinx.android.synthetic.main.activity_page.*
import kotlinx.android.synthetic.main.frame_address1.*


class AddressActivity2 : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v){
            address_continue_btn -> {
                val intent = Intent(applicationContext, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address2)
        addFragment(Map())
        address_continue_btn.setOnClickListener(this)
    }

    fun addFragment(fragment : Fragment){
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.add(R.id.map_frame, fragment)
        transaction.commit()
    }
}


