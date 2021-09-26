package com.abumadi.restrofit


//1-Rest API URL
data class Comment (
    val postId:Int,
    val id:Int,
    val name:String,
    val email:String,
    val body:String
)