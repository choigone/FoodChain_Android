package com.team.foodchain

import okhttp3.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST


interface NetworkService2 {

    @POST("/addrlink/addrLinkApi.do")
    fun postSearchLocation(
            @Body postSearchLocation: PostSearchLocation
    ) : retrofit2.Call<PostSearchLocationResponse>

}
