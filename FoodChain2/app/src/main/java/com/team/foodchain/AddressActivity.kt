package com.team.foodchain

import android.Manifest
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.location.*
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityCompat.requestPermissions
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.RequestManager
import com.google.android.gms.maps.model.LatLng
import com.team.foodchain.R.drawable.address
import com.team.foodchain.R.id.address_location_btn
import com.team.foodchain.R.id.address_search_keyword
import kotlinx.android.synthetic.main.activity_address.*
import kotlinx.android.synthetic.main.activity_page.*
import kotlinx.android.synthetic.main.activity_user_join.*
import kotlinx.android.synthetic.main.frame_address1.*
import kotlinx.android.synthetic.main.frame_address2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import kotlin.collections.Map


class AddressActivity : AppCompatActivity(){

    object addressActivity{

    }

    var ssibal = arrayListOf("dd")



//    override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
//        if(v!!.imeOptions == EditorInfo.IME_ACTION_SEARCH){
//
//            postSearchLocation()
//        }
//        return false
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)
        addFragment(Address1())
        lateinit var networkService2 : NetworkService2
        val builder = Retrofit.Builder()
        val retrofit = builder.baseUrl("http://www.juso.go.kr").addConverterFactory(GsonConverterFactory.create()).build()
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

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

        }
        else {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 0)
            finish()
        }

        address_search_keyword.imeOptions = EditorInfo.IME_ACTION_SEARCH


        address_location_btn.setOnClickListener{
            val lm = getSystemService(Context.LOCATION_SERVICE) as LocationManager

            var location : Location?
            var provider : String? = LocationManager.GPS_PROVIDER

            location = lm.getLastKnownLocation(provider)
            var latitude : String?
            var longitude : String?
            var latitudeD : Double
            var longitudeD : Double
            latitude = location.latitude.toString()
            longitude = location.longitude.toString()
            latitudeD = location.latitude
            longitudeD = location.longitude

            var address : String = run(latitudeD,longitudeD)

            Log.e("text", "위도 : " + latitude + "경도 : " + longitude)
            Log.e("변환했음",address)
        }
        searchIcon.setOnClickListener{
            val address_search_keyword =  address_search_keyword.text.toString()
            val map = HashMap<String, String>()
            map.put("confmKey", "U01TX0FVVEgyMDE4MDcxMTE3MzkxODEwODAwMzE=")
            map.put("currentPage", "1")
            map.put("countPerPage", "100")
            map.put("keyword", address_search_keyword)
            map.put("resultType", "json")
            val postSearchLocationResponse = networkService2.postSearchLocation(map)
            postSearchLocationResponse.enqueue(object : Callback<PostSearchLocationResponse> {
                override fun onFailure(call: Call<PostSearchLocationResponse>?, t: Throwable?) {
                    Log.e("failMessage",call.toString())
                    Log.e("failMessage",t.toString())
                }

                override fun onResponse(call: Call<PostSearchLocationResponse>?, response: Response<PostSearchLocationResponse>?) {
                    if(response!!.isSuccessful){
                        Log.e("Success!",response.body().toString())
                        var count : Int = response.body().results.juso.size
                        ssibal.clear()
                        for(i in 0 until count){
                            ssibal.add(i, response.body().results.juso[i].roadAddrPart1)
                        }

                        if(savedInstanceState == null){
                            val bundle = Bundle()
                            bundle.putStringArrayList("yes",ssibal)
                            address_result_keyword.text = "'" + address_search_keyword +"'"+" 검색 결과"
                            replaceFragment(Address2(), bundle, "yes" )
                        }
                        Log.e("제발요ㅠㅠ",ssibal[0])
                    }
                }

            })
        }
    }

    fun run(address : String) : Address {
        val geocoder = google.maps.geocoder()
        val results = geocoder.getFromLocationName(address, 1)
        val resultAddress = results.get(0)
        val latLng = LatLng(resultAddress.getLatitude(), resultAddress.getLongitude())
        return resultAddress


    }

    fun run(lat : Double, lon : Double) : String {
        val geocoder = Geocoder(this@AddressActivity)
        var addresses : List<Address>? = null
        var addressText = ""
        try
        {
            addresses = geocoder.getFromLocation(lat,lon, 1)
            if (addresses != null && addresses.size > 0)
            {
                val address = addresses.get(0)
                addressText = address.getAdminArea() + " " + (if (address.maxAddressLineIndex > 0) address.getAddressLine(0) else address.locality) + " "
                val txt = address.getSubLocality()
                if (txt != null)
                    addressText += txt + " "
                addressText += address.getThoroughfare() + " " + address.getSubThoroughfare()
            }
            return addressText
        }
        catch (e:Exception) {
            e.printStackTrace()
            return e.toString()
        }
    }

    fun addFragment(fragment : Fragment){
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.add(R.id.address_frame, fragment)
        transaction.commit()
    }

    fun replaceFragment(fragment: Fragment, bundle: Bundle, tag : String){
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        fragment.arguments = bundle
        transaction.replace(R.id.address_frame, fragment, tag)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}