package com.team.foodchain

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Address2 : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        lateinit var addressAdapter : AddressAdapter
        lateinit var addressItem: ArrayList<String>
        val v = inflater!!.inflate(R.layout.frame_address2, container, false)
        lateinit var addressData : ArrayList<String>
        addressData = arguments!!.getStringArrayList("yes")
        var recyclerView : RecyclerView = v.findViewById(R.id.address_list)
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        addressItem = addressData
        addressAdapter = AddressAdapter(addressItem)
        recyclerView.adapter = addressAdapter

        return v
    }
}