package com.example.mywallet.domain.model

import com.google.gson.annotations.SerializedName

data class AllQuoteDC(
    @SerializedName("quotes")
    val quote:List<QuoteDC>?=null
)

data class QuoteDC(
    @SerializedName("id")
    val id:Int?=null,
    @SerializedName("author")
    val author:String?=null,
    @SerializedName("quote", alternate = ["message"])
    val quote:String?=null
)