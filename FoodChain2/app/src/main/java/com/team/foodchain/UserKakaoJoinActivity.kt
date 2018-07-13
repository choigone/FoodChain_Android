package com.team.foodchain

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_user_join_kakao.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserKakaoJoinActivity : AppCompatActivity() {

    lateinit var networkService: NetworkService
    //lateinit var kakaoID
    //lateinit var kakaoNickname
    //lateinit var kakaoID:String
    //lateinit var kakaoNickname:String

    //var kakaoID:String= intent.getStringExtra("kakaoID")

    // var kakaoNickname :String = intent.getStringExtra("kakaoNickname")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_join_kakao)
        networkService = GlobalApplication.instance.networkSerVice

        var kakaoID:String= intent.getStringExtra("kakaoID")
        var kakaoNickname :String = intent.getStringExtra("kakaoNickname")

        Log.e("Profile", kakaoID + kakaoNickname)
        user_join_btn_.setOnClickListener{
            postUserSignup(kakaoID, kakaoNickname)
        }
    }

    fun postUserSignup(kakaoID: String, kakaoNickname: String) {

        val user_id = kakaoID
        val user_name = kakaoNickname

        // val user_id:String= intent.getStringExtra("kakaoID")
        //  val user_name :String = intent.getStringExtra("kakaoNickname")
        val user_pw =user_id
        val user_pw_check = user_id
        //    val user_pw_check =  user_join_pwcheck.text.toString()
        //     val user_pw = user_join_pw.text.toString()
        //      val user_name = user_join_name.text.toString()
        val user_email = user_kakao_email.text.toString()
        val user_phone = user_kakao_phone.text.toString()
//        val user_id : String? = null

        val postSignupGeneral = PostSignupGeneral(user_pw, user_name, user_email, user_phone, user_id)

        val postSignupGeneralResponse = networkService.postSignGeneral(postSignupGeneral)
        postSignupGeneralResponse.enqueue(object : Callback<PostSignupGeneralResponse>{
            override fun onFailure(call: Call<PostSignupGeneralResponse>?, t: Throwable?) {
                Log.v("test", "dhdhdhdh")
            }

            override fun onResponse(call: Call<PostSignupGeneralResponse>?, response: Response<PostSignupGeneralResponse>?)
            {
                if(response!!.isSuccessful)
                {
                    Log.e("token", response.body().token)
                    Log.e("cate_flag", response.body().cate_flag.toString())
                    //   Log.e("locate_flag", response.body().)
                    // Log.e("", response.body().)

                    val intent = Intent(applicationContext, ChoiceActivity::class.java)
                    intent.putExtra("token", response.body().token)

                    startActivity(intent)
                }
            }
        })
    }
}