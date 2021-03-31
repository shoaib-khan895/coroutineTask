package com.example.Coroutine.retrofit

import com.example.Coroutine.model.DataModel
import retrofit2.http.GET

interface ApiInterface {

    // Define end point
    @GET("posts")
    fun getPost(): retrofit2.Call<List<DataModel>>
}