package com.team.foodchain

import android.Manifest
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityCompat.requestPermissions
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_page.*

//var isLocate = 0

class AddressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)
        addFragment(Address1())

//        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
//                == PackageManager.PERMISSION_GRANTED) {
//            isLocate = 1
//        } else {
//            isLocate = 0
//            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 0)
//            finish()
//        }

        if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
//            isLocate = 0
        }
//        else {
//            isLocate = 1
//        }

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


//    fun showGpsAlert(){
//        var alertDialog : AlertDialog? = null
//        alertDialog!!.setTitle("'푸드체인'을 사용하는 동안 해당 앱이 사용자의 위치에 접근하도록 허용하겠습니까?")
//        alertDialog!!.setMessage("가까운 동네를 검색하거나 동네인증을 위해 현재 위치를 확인합니다.")
//        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "허용 안 함", DialogInterface.OnClickListener())
//
//    }

}