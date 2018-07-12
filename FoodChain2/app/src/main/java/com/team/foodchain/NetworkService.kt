package com.team.foodchain

import okhttp3.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface NetworkService {

    @POST("/users/signup/general")
    fun postSignGeneral(
            @Body postSignupGeneral: PostSignupGeneral
    ) : retrofit2.Call<PostSignupGeneralResponse>

    @POST("/users/signup/supplier")
    fun postSignMaster(
            @Body postSignupMaster: PostSignupMaster
    ) : retrofit2.Call<PostSignupMasterResponse>

    @POST("/users/signup/check/email")
    fun postEmailCheck(
            @Body postEmailCheck: PostEmailCheck
    ) : retrofit2.Call<PostEmailCheckResponse>

    @POST("/users/signup/check/phone")
    fun postPhoneCheck(
            @Body postPhoneCheck: PostPhoneCheck
    ) : retrofit2.Call<PostPhoneCheckResponse>

    @POST("/users/choice/set")
    fun postChoice(
            @Header("token") token : String,
            @Body postChoice : PostChoice
    ) : retrofit2.Call<PostChoiceResponse>


}