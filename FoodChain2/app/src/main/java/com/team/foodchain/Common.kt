package com.team.foodchain

data class Common(
        var totalCount : String,
        var currentPage : Int,
        var countPerPage : Int,
        var errorCode : String,
        var errorMessage : String
)