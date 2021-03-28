package com.zillo.mvvmproject.retrofit

import ServicesSetterGetter
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("list?page=34")
    fun getServices() : Call<ServicesSetterGetter>
}