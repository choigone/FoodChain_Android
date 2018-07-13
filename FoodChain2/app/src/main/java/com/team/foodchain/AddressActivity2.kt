package com.team.foodchain


import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions
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
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.team.foodchain.R.drawable.a
import kotlinx.android.synthetic.main.activity_address.*
import kotlinx.android.synthetic.main.activity_address2.*
import kotlinx.android.synthetic.main.activity_page.*
import kotlinx.android.synthetic.main.frame_address1.*


class AddressActivity2 : AppCompatActivity(), View.OnClickListener, OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onClick(v: View?) {
        when(v){
            address_continue_btn -> {
                val intent = Intent(applicationContext, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }

    var array = arrayOf("1","2","3")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address2)
        address_continue_btn.setOnClickListener(this)

        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map_frame) as SupportMapFragment
        mapFragment.getMapAsync(this)

        var latitude = intent.getStringExtra("latitude")
        var longitude = intent.getStringExtra("longitude")
        var address = intent.getStringExtra("address")

        address2_address.text = address

        array[0] = latitude
        array[1] = longitude
        array[2] = address

    }
    override fun onMapReady(p0: GoogleMap?) {
        mMap = p0!!
        val latLng = LatLng(array[0].toDouble(), array[1].toDouble())
        val resultPosition : LatLng = latLng
        val resultAddress = array[2]
        mMap.addMarker(MarkerOptions().position(resultPosition).title(resultAddress))
        val position = CameraPosition.Builder()
                .target(latLng).zoom(16f).build()
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(position))
    }
}


