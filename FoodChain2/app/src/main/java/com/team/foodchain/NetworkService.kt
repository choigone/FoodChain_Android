package com.team.foodchain

import okhttp3.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface NetworkService {

    @POST("/users/signup/general")
    fun postSignGeneral(
            @Body postSignupGeneral: PostSignupGeneral
    ) : retrofit2.Call<PostSignupGeneralResponse>
}