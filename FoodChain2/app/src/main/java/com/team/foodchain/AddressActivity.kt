package com.team.foodchain

import android.Manifest
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
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
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.maps.model.LatLng
import com.team.foodchain.R.drawable.address
import com.team.foodchain.R.id.address_location_btn
import com.team.foodchain.R.id.address_search_keyword
import kotlinx.android.synthetic.main.activity_address.*
import kotlinx.android.synthetic.main.activity_page.*
import kotlinx.android.synthetic.main.activity_user_join.*
import kotlinx.android.synthetic.main.frame_address1.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class AddressActivity : AppCompatActivity(), View.OnClickListener{

//    override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
//        if(v!!.imeOptions == EditorInfo.IME_ACTION_SEARCH){
//
//            postSearchLocation()
//        }
//        return false
//    }

    override fun onClick(v: View?) {
        when(v){
            address_location_btn -> {

            }
//            searchIcon -> {
//                postSearchLocation()
//            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)
        addFragment(Address1())
        lateinit var networkService2 : NetworkService2
        val retrofit = Retrofit.Builder()
                .baseUrl("http://www.juso.go.kr")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
//        val builder = Retrofit.Builder()
//        val retrofit = builder.baseUrl("http://www.juso.go.kr").addConverterFactory(GsonConverterFactory.create()).build()
        networkService2 = retrofit.create((NetworkService2::class.java))

//        keyword = findViewById(R.id.address_search_keyword) as EditText
//        keyword.setImeActionLabel("검색", KeyEvent.KEYCODE_ENTER)
//        keyword.setOnKeyListener(object : View.OnKeyListener{
//            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
//                if ((event!!.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    postSearchLocation()
//                    return true
//                }
//                return false
//            }
//
//        })

        address_location_btn.setOnClickListener(this)
//        searchIcon.setOnClickListener(this)

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

        }
        else {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 0)
            finish()
        }

        val lm = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        var location : Location?
        var provider : String? = LocationManager.GPS_PROVIDER

        location = lm.getLastKnownLocation(provider)
        var latitude : String?
        var longitude : String?
        latitude = location.latitude.toString()
        longitude = location.longitude.toString()

        Log.e("text", "위도 : " + latitude + "경도 : " + longitude)
        address_search_keyword.imeOptions = EditorInfo.IME_ACTION_SEARCH

        searchIcon.setOnClickListener{
            postSearchLocation(networkService2)
        }


    }


    fun addFragment(fragment : Fragment){
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.add(R.id.address_frame, fragment)
        transaction.commit()
    }

    fun postSearchLocation(networkService2 : NetworkService2){

        val address_search_keyword =  address_search_keyword.text.toString()
        val postSearchLocation = PostSearchLocation("U01TX0FVVEgyMDE4MDcxMTE3MzkxODEwODAwMzE=",1, 100, address_search_keyword, "json" )

        val postSearchLocationResponse = networkService2.postSearchLocation(postSearchLocation)
        postSearchLocationResponse.enqueue(object : Callback<PostSearchLocationResponse> {
            override fun onFailure(call: Call<PostSearchLocationResponse>?, t: Throwable?) {
                Log.e("failMessage",t.toString())
            }

            override fun onResponse(call: Call<PostSearchLocationResponse>?, response: Response<PostSearchLocationResponse>?) {
                if(response!!.isSuccessful){
                    Log.e("Success!","제발요!")
                }
            }

        })
    }

}