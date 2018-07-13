package com.team.foodchain

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_choice.*
import kotlinx.android.synthetic.main.activity_page.*
import kotlinx.android.synthetic.main.activity_user_join.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ChoiceActivity : AppCompatActivity(), View.OnClickListener {

    var num : Int = 0
    lateinit var token : String
    lateinit var pro_cate : ArrayList<String>
    var flag=0
    var check : IntArray= intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)

    override fun onClick(v: View?) {
        when(v){
            category0_a-> {
                if(category0_a.isSelected==true)
                {
                    category0_a.isSelected = false
                    check[0] = 0
                }
                else if(category0_a.isSelected ==false)
                {
                    category0_a.isSelected = true
                    check[0] = 1
                    pro_cate.add("0_a")

                }
            }
            category0_b -> {
                if(category0_b.isSelected==true){
                    category0_b.isSelected = false
                    check[1] = 0
                }
                else if(category0_b.isSelected ==false){
                    category0_b.isSelected = true
                    check[1] = 1
                    pro_cate.add("0_b")
                }
            }
            category1_a -> {
                if(category1_a.isSelected==true){
                    category1_a.isSelected = false
                    check[2] = 0
                }
                else if(category1_a.isSelected ==false){
                    category1_a.isSelected = true
                    check[2] = 1
                    pro_cate.add("1_a")
                }
            }
            category1_b -> {
                if(category1_b.isSelected==true){
                    category1_b.isSelected = false
                    check[3] = 0
                }
                else if(category1_b.isSelected ==false){
                    category1_b.isSelected = true
                    check[3] = 1
                    pro_cate.add("1_b")

                } }

            category1_c -> {
                if(category1_c.isSelected==true) {
                    category1_c.isSelected = false
                    check[4] = 0
                }
                else if(category1_c.isSelected ==false){
                    category1_c.isSelected = true
                    check[4] = 1

                    pro_cate.add("1_c")
                }            }

            category1_d -> {

                if(category1_d.isSelected==true){
                    category1_d.isSelected = false
                    check[5] = 0
                }
                else if(category1_d.isSelected ==false){
                    category1_d.isSelected = true
                    check[5] = 1

                    pro_cate.add("1_d")
                }
            }

            category2 -> {
                if(category2.isSelected==true){
                    category2.isSelected = false
                    check[6] = 0
                }
                else if(category2.isSelected ==false){
                    category2.isSelected = true
                    check[6] = 1

                    pro_cate.add("2")
                }
            }
            category3_a -> {
                if(category3_a.isSelected==true){
                    category3_a.isSelected = false
                    check[7] = 0

                }
                else if(category3_a.isSelected ==false){
                    category3_a.isSelected = true
                    check[7] = 1

                    pro_cate.add("3_a")
                }

            }
            category3_b -> {

                if(category3_b.isSelected==true){
                    category3_b.isSelected = false
                    check[8] = 0
                }
                else if(category3_b.isSelected ==false){
                    category3_b.isSelected = true
                    check[8] = 1

                    pro_cate.add("3_b")
                }
            }

            category3_c -> {

                if(category3_c.isSelected==true){
                    category3_c.isSelected = false
                    check[9] = 0
                }
                else if(category3_c.isSelected ==false){
                    category3_c.isSelected = true
                    check[9] = 1

                    pro_cate.add("3_c")
                }
            }

            category4 -> {
                if(category4.isSelected==true){
                    category4.isSelected = false
                    check[10] = 0
                }
                else if(category4.isSelected ==false){
                    category4.isSelected = true
                    check[10] = 1

                    pro_cate.add("4")
                }
            }

            category5_a -> {

                if(category5_a.isSelected==true){
                    check[11] = 0
                    category5_a.isSelected = false
                }
                else if(category5_a.isSelected ==false){
                    category5_a.isSelected = true
                    check[11] = 1

                    pro_cate.add("5_a")
                }
            }

            category5_b -> {

                if(category5_b.isSelected==true){
                    category5_b.isSelected = false
                    check[12] = 0
                }
                else if(category5_b.isSelected ==false){
                    category5_b.isSelected = true
                    check[12] = 1

                    pro_cate.add("5_b")
                }
            }

            category6_a -> {

                if(category6_a.isSelected==true){
                    category6_a.isSelected = false
                    check[13] = 0

                }
                else if(category6_a.isSelected ==false){
                    category6_a.isSelected = true
                    check[13] = 1

                    pro_cate.add("6_a")
                }
            }

            category6_b -> {

                if(category6_b.isSelected==true){
                    category6_b.isSelected = false
                    check[14] = 0

                }
                else if(category6_b.isSelected ==false){
                    category6_b.isSelected = true
                    check[14] = 1

                    pro_cate.add("6_b")
                }
            }

            category6_c -> {

                if(category6_c.isSelected==true){
                    category6_c.isSelected = false
                    check[15] = 0
                }
                else if(category6_c.isSelected ==false){
                    category6_c.isSelected = true
                    check[15] = 1

                    pro_cate.add("6_c")
                }
            }
            category6_d -> {


                if(category6_d.isSelected==true){
                    category6_d.isSelected = false
                    check[16] = 0
                }
                else if(category6_d.isSelected ==false){
                    category6_d.isSelected = true
                    check[16] = 1

                    pro_cate.add("6_d")
                }

            }
            category6_e -> {


                if(category6_e.isSelected==true){
                    category6_e.isSelected = false
                    check[17] = 0
                }
                else if(category6_e.isSelected ==false){
                    category6_e.isSelected = true
                    check[17] = 1

                    pro_cate.add("6_e")
                }
            }
            category7_a -> {


                if(category7_a.isSelected==true){
                    category7_a.isSelected = false
                    check[18] = 0
                }
                else if(category7_a.isSelected ==false){
                    category7_a.isSelected = true
                    check[18] = 1

                    pro_cate.add("7_a")
                } }
            category7_b ->{


                if(category7_b.isSelected==true){
                    category7_b.isSelected = false
                    check[19] = 0
                }
                else if(category7_b.isSelected ==false){
                    category7_b.isSelected = true
                    check[19] = 1

                    pro_cate.add("7_b")
                }
            }

        }
    }

    lateinit var networkService: NetworkService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)
        pro_cate = ArrayList<String>()
        category0_a.setOnClickListener(this)
        category0_b.setOnClickListener(this)
        category1_a.setOnClickListener(this)
        category1_b.setOnClickListener(this)
        category1_c.setOnClickListener(this)
        category1_d.setOnClickListener(this)
        category2.setOnClickListener(this)
        category3_a.setOnClickListener(this)
        category3_b.setOnClickListener(this)
        category3_c.setOnClickListener(this)
        category4.setOnClickListener(this)
        category5_a.setOnClickListener(this)
        category5_b.setOnClickListener(this)
        category6_a.setOnClickListener(this)
        category6_b.setOnClickListener(this)
        category6_c.setOnClickListener(this)
        category6_d.setOnClickListener(this)
        category6_e.setOnClickListener(this)
        category7_a.setOnClickListener(this)
        category7_b.setOnClickListener(this)

        networkService = GlobalApplication.instance.networkSerVice

        token = intent.getStringExtra("token")

        choice_confirm_tv.setOnClickListener{

            for(i in check.indices)
            {
                if(check[i] == 1)
                {
                    num +=1
                }
            }


            if(num == 2) {
                postChoice(pro_cate)
            }
            else
            {
                val intent = Intent(applicationContext, ChoiceActivity::class.java)
                intent.putExtra("token", token)
                startActivity(intent)
            }
        }
    }

    fun postChoice(pro_cate : ArrayList<String>){

        val postChoice = PostChoice(pro_cate)

        val postChoiceResponse = networkService.postChoice(token,postChoice)
        postChoiceResponse.enqueue(object : Callback<PostChoiceResponse> {
            override fun onFailure(call: Call<PostChoiceResponse>?, t: Throwable?) {
                Log.v("text", t.toString())
            }

            override fun onResponse(call: Call<PostChoiceResponse>?, response: Response<PostChoiceResponse>?) {


                if(response!!.isSuccessful){
                    Log.e("check", response.body().message)

                    val intent = Intent(applicationContext, HomeActivity::class.java)
                    startActivity(intent)
                }
            }
        })
    }

}