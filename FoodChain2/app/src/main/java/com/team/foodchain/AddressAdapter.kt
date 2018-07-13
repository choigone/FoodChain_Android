package com.team.foodchain

import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager

class AddressAdapter(var AddressItem : ArrayList<String>) : RecyclerView.Adapter<AddressViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        val mainView : View = LayoutInflater.from(parent.context)
                .inflate(R.layout.address_item, parent, false)
        return AddressViewHolder(mainView)
    }
    override fun getItemCount(): Int  = AddressItem.size

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
        holder.Address.text = AddressItem[position]

    }
}