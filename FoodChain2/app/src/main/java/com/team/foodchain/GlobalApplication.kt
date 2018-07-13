package com.team.foodchain

import android.app.Activity
import android.app.Application

import com.kakao.auth.KakaoSDK
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GlobalApplication : Application() {
    lateinit var networkSerVice : NetworkService
    private val baseUrl = "https://www.eatda.cf"

    override fun onCreate() {
        super.onCreate()
        instance = this
        globalApplicationContext = this
        KakaoSDK.init(KakaoSDKAdapter())
        buildNetwork()
    }

    fun buildNetwork(){
        val builder = Retrofit.Builder()
        val retrofit = builder
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        networkSerVice = retrofit.create(NetworkService::class.java)
    }

    companion object {
        lateinit var instance: GlobalApplication
        @Volatile
        var globalApplicationContext: GlobalApplication? = null
            private set
        // Activity가 올라올때마다 Activity의 onCreate에서 호출해줘야한다.
        @Volatile
        var currentActivity: Activity? = null
    }
}

