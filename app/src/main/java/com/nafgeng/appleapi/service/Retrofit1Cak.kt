package com.nafgeng.appleapi.service

import com.nafgeng.appleapi.response.PostsItem
import com.nafgeng.appleapi.response.ResponseCak
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

object Retrofit1Cak {

    private val client : OkHttpClient = OkHttpClient.Builder().build()

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl("https://onecak.azurewebsites.net/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun getService() = retrofit.create(OneCak::class.java)
}

interface OneCak {

    @GET("?lol")
    fun getDataOneCak() : Call<ResponseCak>

}