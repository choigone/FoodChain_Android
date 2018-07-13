package com.team.foodchain

import okhttp3.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT

interface NetworkService {

    @POST("/users/signup/general")
    fun postSignGeneral(
            @Body postSignupGeneral: PostSignupGeneral
    ) : retrofit2.Call<PostSignupGeneralResponse>

    @POST("/users/signin/native")
    fun postSignIn(
            @Body postSigninGeneral : PostSigninGeneral
    ):retrofit2.Call<PostSigninGeneralResponse>

    @POST("/users/signin/kakao")
    fun postkakaoSignin(
            @Body postKakaoGeneral : PostKakaoGeneral

    ):retrofit2.Call<PostKakaoGeneralResponse>

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

    @POST("/users/locate")
    fun postLocate(
            @Header("token") token: String,
            @Body postUserLocate: PostUserLocate
    ) : retrofit2.Call<PostUserLocateResponse>

}