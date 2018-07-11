package com.team.foodchain

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_choice.*
import kotlinx.android.synthetic.main.activity_page.*
import kotlinx.android.synthetic.main.activity_user_join.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

var isFirst = 0

class ChoiceActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var pro_cate : Array<String>
    var flag = 0


    override fun onClick(v: View?) {
        when(v){
            category0_a-> {
                category0_a.isSelected = true
                pro_cate[flag] = "0_a"
                flag++
            }
            category0_b -> {
                category0_a.isSelected = true
                pro_cate[flag] = "0_b"
                flag++
            }
            category1_a -> {
                category1_a.isSelected = true
                pro_cate[flag] = "1_a"
                flag++
            }
            category1_b -> {
                category1_b.isSelected = true
                pro_cate[flag] = "1_b"
                flag++
            }
            category1_c -> {
                category1_c.isSelected = true
                pro_cate[flag] = "1_c"
                flag++
            }
            category1_d -> {
                category1_d.isSelected = true
                pro_cate[flag] = "1_d"
                flag++
            }
            category1_e -> {
                category1_e.isSelected = true
                pro_cate[flag] = "1_e"
                flag++
            }
            category2 -> {
                category2.isSelected = true
                pro_cate[flag] = "2"
                flag++
            }
            category3_a -> {
                category3_a.isSelected = true
                pro_cate[flag] = "3_a"
                flag++
            }
            category3_b -> {
                category3_b.isSelected = true
                pro_cate[flag] = "3_b"
                flag++
            }
            category3_c -> {
                category3_c.isSelected = true
                pro_cate[flag] = "3_c"
                flag++
            }
            category3_d -> {
                category3_d.isSelected = true
                pro_cate[flag] = "3_d"
                flag++
            }
            category3_e ->{
                category3_e.isSelected = true
                pro_cate[flag] = "3_e"
                flag++
            }
            category4 -> {
                category4.isSelected = true
                pro_cate[flag] = "4"
                flag++
            }
            category5_a -> {
                category5_a.isSelected = true
                pro_cate[flag] = "5_a"
                flag++
            }
            category5_b -> {
                category5_b.isSelected = true
                pro_cate[flag] = "5_b"
                flag++
            }
            category6_a -> {
                category6_a.isSelected = true
                pro_cate[flag] = "6_a"
                flag++
            }
            category6_b -> {
                category6_b.isSelected = true
                pro_cate[flag] = "6_b"
                flag++
            }
            category6_c -> {
                category6_c.isSelected = true
                pro_cate[flag] = "6_c"
                flag++
            }
            category6_d -> {
                category6_d.isSelected = true
                pro_cate[flag] = "6_d"
                flag++
            }
            category6_e -> {
                category6_e.isSelected = true
                pro_cate[flag] = "6_e"
                flag++
            }
            category6_f -> {
                category6_f.isSelected = true
                pro_cate[flag] = "6_f"
                flag++
            }
            category7_a -> {
                category7_a.isSelected = true
                pro_cate[flag] = "7_a"
                flag++
            }
            category7_b ->{
                category7_b.isSelected = true
                pro_cate[flag] = "7_b"
                flag++
            }

        }
    }

    lateinit var networkService: NetworkService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)
        category0_a.setOnClickListener(this)
        category0_b.setOnClickListener(this)
        category1_a.setOnClickListener(this)
        category1_b.setOnClickListener(this)
        category1_c.setOnClickListener(this)
        category1_d.setOnClickListener(this)
        category1_e.setOnClickListener(this)
        category2.setOnClickListener(this)
        category3_a.setOnClickListener(this)
        category3_b.setOnClickListener(this)
        category3_c.setOnClickListener(this)
        category3_d.setOnClickListener(this)
        category3_e.setOnClickListener(this)
        category4.setOnClickListener(this)
        category5_a.setOnClickListener(this)
        category5_b.setOnClickListener(this)
        category6_a.setOnClickListener(this)
        category6_b.setOnClickListener(this)
        category6_c.setOnClickListener(this)
        category6_d.setOnClickListener(this)
        category6_e.setOnClickListener(this)
        category6_f.setOnClickListener(this)
        category7_a.setOnClickListener(this)
        category7_b.setOnClickListener(this)

        isFirst = 1
        networkService = ApplicationController.instance.networkSerVice

        choice_confirm_tv.setOnClickListener{
            postChoice(pro_cate)
        }
    }

    fun postChoice(pro_cate : Array<String>){

        val postChoice = PostChoice(pro_cate)


        val postChoiceResponse = networkService.postChoice("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImxlZXNkNTU2QGdtYWlsLmNvbSIsInBob25lIjoiMDEwMjExMjE4OTEiLCJpZGVudGlmeSI6IjAiLCJpYXQiOjE1MzA4MjA0NTF9.GzfkSKwWsAybAm5FMgkJHmkQY6ZpP1368NnAVQIQOks",postChoice)
        postChoiceResponse.enqueue(object : Callback<PostChoiceResponse> {
            override fun onFailure(call: Call<PostChoiceResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<PostChoiceResponse>?, response: Response<PostChoiceResponse>?) {
                if(response!!.isSuccessful){
                    val intent = Intent(applicationContext, HomeActivity::class.java)
                    startActivity(intent)
                }
            }
        })
    }

}