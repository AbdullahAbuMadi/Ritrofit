package com.abumadi.restrofit

import retrofit2.Call
import retrofit2.http.*

//2-Interface
interface APIinterface {

    @GET("posts")
    fun getPost():Call<List<Post>>

    @GET("posts/{id}")
    fun getPostWithPath(@Path("id") id:Int):Call<Post>

    @GET("posts/{id}/{comments}")
    fun getPostWithTowPath(@Path("id") id:Int,@Path("comments")comments:String):Call<List<Comment>>

    @GET("comments")
    fun getComment(@Query("postId") postId: Int): Call<List<Comment>>

    @POST("posts")
    fun storePost(@Body post: Post): Call<Post>

    @POST("posts")
    fun storeMap(@Body map:HashMap<Any,Any>):Call<HashMap<Any,Any>>
}