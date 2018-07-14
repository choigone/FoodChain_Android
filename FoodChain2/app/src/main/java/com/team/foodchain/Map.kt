package com.team.foodchain

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

class Map : Fragment() {

//    private lateinit var map :GoogleMap

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater!!.inflate(R.layout.fragment_map, container, false)
//        lateinit var addressData : Array<String>
//        addressData = arguments!!.getStringArray("good")



//        var latLng = LatLng(addressData[0].toDouble(),addressData[1].toDouble())
//        var position = CameraPosition.builder().target(latLng).zoom(16F).build()
//        map.moveCamera(CameraUpdateFactory.newCameraPosition(position))


        return v
    }

//    override fun onMapReady(p0: GoogleMap?) {
//        map = p0!!
//    }
}