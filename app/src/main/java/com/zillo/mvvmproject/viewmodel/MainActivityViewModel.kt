package com.zillo.mvvmproject.viewmodel

import ServicesSetterGetter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zillo.mvvmproject.repository.MainActivityRepository

class MainActivityViewModel : ViewModel()  {

    var servicesLiveData: MutableLiveData<ServicesSetterGetter>? = null

    fun getUser() : LiveData<ServicesSetterGetter>? {
        servicesLiveData = MainActivityRepository.getServicesApiCall()
        return servicesLiveData
    }
}