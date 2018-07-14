package com.team.foodchain

data class GetMarketNearData(
        var user_addr : String,
        var user_addr_lat : String,
        var user_addr_long : String,
        var market: ArrayList<Market>
)