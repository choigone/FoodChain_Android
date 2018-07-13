package com.team.foodchain

import android.location.Address
import android.location.Geocoder
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.team.foodchain.R.id.address_list
import kotlinx.android.synthetic.main.frame_address2.*

class AddressAdapter(var AddressItem : ArrayList<String>) : RecyclerView.Adapter<AddressViewHolder>() {

    var resultAddress : String? = null

    private lateinit var onItemClick : View.OnClickListener
    fun setOnItemClick(l: Address2){
        onItemClick = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        val mainView : View = LayoutInflater.from(parent.context)
                .inflate(R.layout.address_item, parent, false)
        mainView.setOnClickListener(onItemClick)
        var addressActivity = AddressActivity()
        var convertAddress : Address = addressActivity.run(resultAddress!!)
        Log.e("안녕",convertAddress.latitude.toString() + convertAddress.longitude.toString())

        return AddressViewHolder(mainView)
    }
    override fun getItemCount(): Int  = AddressItem.size

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
        holder.Address.text = AddressItem[position]

        holder.itemView.setOnClickListener{
            resultAddress = AddressItem[position]
            Log.e("클릭되라고!!!",AddressItem[position])


        }
    }


}