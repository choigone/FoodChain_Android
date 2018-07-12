package com.team.foodchain

import okhttp3.Call
import retrofit2.http.*


interface NetworkService2 {

    @GET("/addrlink/addrLinkApi.do")
    fun postSearchLocation(
            @QueryMap map: HashMap<String, String>
    ) : retrofit2.Call<PostSearchLocationResponse>

}
