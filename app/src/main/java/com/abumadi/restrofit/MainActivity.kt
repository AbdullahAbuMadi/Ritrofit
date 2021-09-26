package com.abumadi.restrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {

    //pass obj of class to post
    val obj = Post(1, 2, "Abdullah","Something")
    //pass map to post : if we cannot combine our data in same class
    var map = HashMap<Any,Any>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        map.put("title","AbuMadi")
        map.put("body","Any")
        map.put("userId",2)

        //3&4-builder and converter
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiInterface: APIinterface = retrofit.create(APIinterface::class.java)

        //5- Call
        //a)
        val getPostWithTwoPath:Call<List<Comment>> = apiInterface.getPostWithTowPath(3,"comments")
        val getPostWithId:Call<Post> = apiInterface.getPostWithPath(1)
        val getCallPost:Call<List<Post>> = apiInterface.getPost()
        val getCall: Call<List<Comment>> = apiInterface.getComment(20)
        val postCall: Call<Post> = apiInterface.storePost(obj)
        val postMapCall:Call<HashMap<Any,Any>> = apiInterface.storeMap(map)



//        getPostWithTwoPath.enqueue(object :Callback<List<Comment>>{
//            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
//                PostTV.text = response.body()?.get(0)?.email
//            }
//
//            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//        })
//        getPostWithId.enqueue(object : Callback<Post> {
//            override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                PostTV.text = response.body()?.body
//            }
//
//            override fun onFailure(call: Call<Post>, t: Throwable) {
//                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
//            }
//        })
//        getCallPost.enqueue(object : Callback<List<Post>> {
//            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
//                PostTV.text = response.body()?.get(0)?.body
//            }
//
//            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
//                PostTV.text =t.message
//            }
//            })

//        b)
        //get List
//        getCall.enqueue(object : Callback<List<Comment>> {
//
//            //there is response from the server
//            override fun onResponse(getCall: Call<List<Comment>>, response: Response<List<Comment>>) {
//                PostTV.text= response.body()?.get(0)?.id.toString()
//
//            }
//
//            //there is no response from the server ,couldn't parse the GESON from server
//            override fun onFailure(getCall: Call<List<Comment>>, t: Throwable) {
//                //throwable is the error
//                PostTV.text=t.message
//            }
//
//
//        })

        //Post Obj
//        postCall.enqueue(object : Callback<Post> {
//            override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                Toast.makeText(applicationContext, response.body()?.title, Toast.LENGTH_LONG).show()
//            }
//
//            override fun onFailure(call: Call<Post>, t: Throwable) {
//                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
//            }
//
//        })

        //postMap
//        postMapCall.enqueue(object: Callback<HashMap<Any, Any>> {
//            override fun onResponse(
//                call: Call<HashMap<Any, Any>>,
//                response: Response<HashMap<Any, Any>>
//            ) {
//                PostTV.text= response.body()?.get("userId").toString()
//
//                Toast.makeText(applicationContext, "Map posted", Toast.LENGTH_LONG).show()            }
//
//            override fun onFailure(call: Call<HashMap<Any, Any>>, t: Throwable) {
//                Toast.makeText(applicationContext, "Map failed", Toast.LENGTH_LONG).show()            }
//            })
    }
}