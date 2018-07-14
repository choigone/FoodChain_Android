package com.team.foodchain

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.team.foodchain.R.id.*
import kotlinx.android.synthetic.main.activity_page.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity(), View.OnClickListener, OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    lateinit var networkService : NetworkService
    lateinit var marketItems : ArrayList<Market>
    lateinit var userAddress : GetMarketNearData

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

        val getMarketNearResponse = networkService.getMarket("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6Imh5dW5zMzFAaGFubWFpbC5uZXQiLCJwdyI6IjJLUjQ5eEwveEVydzN6TEtxQWh4N3V2UE9WR0kySVUxd2toa204TFMvbU09IiwiaWRlbnRpZnkiOjEsImlhdCI6MTUzMTUyNjAyNn0.HTl2Liea-053H409DbIgcxtnxPtss-BIR32srBvqTpg")
        getMarketNearResponse.enqueue(object : Callback<GetMarketNearResponse>{
            override fun onFailure(call: Call<GetMarketNearResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<GetMarketNearResponse>?, response: Response<GetMarketNearResponse>?) {
                marketItems = response!!.body().data.market
                userAddress = response!!.body().data
            }

        })

        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map_frame) as SupportMapFragment
        mapFragment.getMapAsync(this)


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
    override fun onMapReady(p0: GoogleMap?) {
        mMap = p0!!
        var index = marketItems.size
        val latLng = LatLng(userAddress.user_addr_lat.toDouble(), userAddress.user_addr_long.toDouble())
        val userResultPosition : LatLng = latLng
        lateinit var MarketPositions : ArrayList<LatLng>
        for (i in 0 until index){
            MarketPositions[i] = LatLng(marketItems[i].mar_locate_lat.toDouble(),marketItems[i].mar_locate_long.toDouble() )
        }
        mMap.addMarker(MarkerOptions().position(userResultPosition).title(userAddress.user_addr))
        for(i in 0 until index){
            mMap.addMarker(MarkerOptions().position(MarketPositions[i]).title(marketItems[i].mar_addr))
        }
        val position = CameraPosition.Builder()
                .target(latLng).zoom(16f).build()
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(position))
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