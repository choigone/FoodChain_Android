package com.team.foodchain

data class PostSearchLocation (
        var confmKey : String,
        var currentPage : Int,
        var countPerPage : Int,
        var keyword : String,
        var resultType : String?
)