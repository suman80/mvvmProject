package com.zillo.mvvmproject.repository

import ServicesSetterGetter
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.zillo.mvvmproject.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {

    val serviceSetterGetter = MutableLiveData<ServicesSetterGetter>()

    fun getServicesApiCall(): MutableLiveData<ServicesSetterGetter> {
        val call = RetrofitClient.apiInterface.getServices()

        call.enqueue(object: Callback<ServicesSetterGetter> {
            override fun onFailure(call: Call<ServicesSetterGetter>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<ServicesSetterGetter>,
                response: Response<ServicesSetterGetter>
            ) {
                Log.d("DEBUG_response", response.body().toString())

                val data = response.body()
               serviceSetterGetter.value = data
            }
        })

        return serviceSetterGetter
    }
}