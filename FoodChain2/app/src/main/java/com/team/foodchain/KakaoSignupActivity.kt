package com.team.foodchain

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log

import com.kakao.auth.ApiResponseCallback
import com.kakao.auth.ErrorCode
import com.kakao.network.ErrorResult
import com.kakao.usermgmt.UserManagement
import com.kakao.usermgmt.callback.MeResponseCallback
import com.kakao.usermgmt.response.model.UserProfile

import com.kakao.util.helper.log.Logger
import kotlinx.android.synthetic.main.activity_user_join_kakao.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KakaoSignupActivity : Activity() {
    /**
     * Main으로 넘길지 가입 페이지를 그릴지 판단하기 위해 me를 호출한다.
     * @param savedInstanceState 기존 session 정보가 저장된 객체
     */
    lateinit var networkService: NetworkService

    lateinit var kakaoID :String
    lateinit var kakaoNickname:String

    var check = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        networkService = GlobalApplication.instance.networkSerVice

        super.onCreate(savedInstanceState)

        requestMe()


    }

    fun postkakaoSignin() {

        val id = kakaoID
        //    val user_name = kakaoNickname

        // val user_id:String= intent.getStringExtra("kakaoID")
        //  val user_name :String = intent.getStringExtra("kakaoNickname")

        //    val user_pw_check =  user_join_pwcheck.text.toString()
        //     val user_pw = user_join_pw.text.toString()
        //      val user_name = user_join_name.text.toString()
        //   val user_email = user_kakao_email.text.toString()
        //   val user_phone = user_kakao_phone.text.toString()
//        val user_id : String? = null

        val postKakaoGeneral = PostKakaoGeneral(id)
        val postKakaoGeneralResponse = networkService.postkakaoSignin((postKakaoGeneral))


        postKakaoGeneralResponse.enqueue(object : Callback<PostKakaoGeneralResponse> {
            override fun onFailure(call: Call<PostKakaoGeneralResponse>?, t: Throwable?) {
                Log.v("test", "dhdhdhdh")

                redirectMainActivity()

            }

            override fun onResponse(call: Call<PostKakaoGeneralResponse>?, response: Response<PostKakaoGeneralResponse>?)
            {

                if(response!!.isSuccessful)
                {
                    var token: String = response!!.body().token

                    Log.e("token", token)
                    Log.e("cate_flag",response.body().cate_flag.toString())
                    Log.e("identify", response.body().identify.toString())
                    Log.e("locate_flag", response.body().locate_flag.toString())

                    if (response.body().cate_flag == 1) {
                        val intent = Intent(applicationContext, HomeActivity::class.java)
                        intent.putExtra("token", token)
                        startActivity(intent)
                    } else {
                        val intent = Intent(applicationContext, ChoiceActivity::class.java)
                        intent.putExtra("token", token)
                        startActivity(intent)
                    } }
            }
        })
    }
    /**
     * 사용자의 상태를 알아 보기 위해 me API 호출을 한다.
     */
    protected fun requestMe() { //유저의 정보를 받아오는 함수
        UserManagement.requestMe(object : MeResponseCallback() {
            override fun onFailure(errorResult: ErrorResult?) {
                val message = "failed to get user info. msg=" + errorResult!!
                Logger.d(message)

                val result = ErrorCode.valueOf(errorResult.errorCode)
                if (result == ErrorCode.CLIENT_ERROR_CODE) {
                    finish()
                } else {
                    redirectLoginActivity()
                }
            }

            override fun onSessionClosed(errorResult: ErrorResult) {
                redirectLoginActivity()
            }
            override fun onNotSignedUp() {} // 카카오톡 회원이 아닐 시 showSignup(); 호출해야함

            override fun onSuccess(userProfile: UserProfile) {  //성공 시 userProfile 형태로 반환

                kakaoID = userProfile.id.toString()
//                  intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                kakaoNickname = userProfile.nickname     // Nickname 값을 가져옴
                Log.e("Profile", kakaoID + kakaoNickname)

                //  inten.putExtra("kakaoID", kakaoID)
                //  inten.putExtra("kakaoNickname", kakaoNickname)

                //         redirectMainActivity() // 로그인 성공시 MainActivity로
                postkakaoSignin()
            }
        })
    }

    private fun redirectMainActivity() {
        //  startActivity(Intent(this, KakaoJoinActivity::class.java))

        val inten = Intent(this, KakaoJoinActivity::class.java)

        inten.putExtra("kakaoID", kakaoID)
        inten.putExtra("kakaoNickname", kakaoNickname)

        startActivity(inten)
        finish()
    }

    protected fun redirectLoginActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
        startActivity(intent)
        finish()
    }
}