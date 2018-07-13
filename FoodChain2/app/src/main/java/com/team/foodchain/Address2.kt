package com.team.foodchain

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.frame_address2.*


class Address2 : Fragment(), View.OnClickListener{
    override fun onClick(v: View?) {
            val index = address_list!!.getChildAdapterPosition(v!!)
            Log.e("아이템클릭",addressItem[index])

    }

    lateinit var addressItem: ArrayList<String>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        lateinit var addressAdapter : AddressAdapter
        val v = inflater!!.inflate(R.layout.frame_address2, container, false)
        lateinit var addressData : ArrayList<String>
        addressData = arguments!!.getStringArrayList("yes")
        var recyclerView : RecyclerView = v.findViewById(R.id.address_list)
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        addressItem = addressData
        addressAdapter = AddressAdapter(addressItem)
        addressAdapter.setOnItemClick(this)
        recyclerView.adapter = addressAdapter
        return v
    }
}