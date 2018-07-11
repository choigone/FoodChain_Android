package com.team.foodchain

import android.Manifest
import android.content.Context
import android.content.DialogInterface
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
import kotlinx.android.synthetic.main.activity_page.*
import kotlinx.android.synthetic.main.frame_address1.*

//var isLocate = 0

class AddressActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v){
            address_location_btn -> {

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)
        addFragment(Address1())
        address_location_btn.setOnClickListener(this)

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

        }
        else {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 0)
            finish()
        }

//        val lm = getSystemService(Context.LOCATION_SERVICE) as LocationManager
//
//        var location : Location? = null
//        var provider : String? = LocationManager.GPS_PROVIDER
//
//        location = lm.getLastKnownLocation(provider)
//        var latitude : String?
//        var longitude : String?
//        latitude = location.latitude.toString()
//        longitude = location.longitude.toString()
//
//        test.setText(latitude + longitude, TextView.TEXT_ALIGNMENT_CENTER)
//
//        Log.e("text", "위도 : " + latitude + "경도 : " + longitude)




    }


    fun addFragment(fragment : Fragment){
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.add(R.id.address_frame, fragment)
        transaction.commit()
    }

    fun replaceFragment(fragment: Fragment){
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.address_frame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}