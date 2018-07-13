package com.team.foodchain

import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class AddressViewHolder(itemView: View? ) : RecyclerView.ViewHolder(itemView) {
    var Address : TextView = itemView!!.findViewById(R.id.address_item_text) as TextView

}