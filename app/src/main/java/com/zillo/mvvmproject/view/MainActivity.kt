package com.zillo.mvvmproject.view

import ImageRecyclerAdapter
import android.app.PendingIntent.getActivity
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cooltechworks.views.shimmer.ShimmerRecyclerView
import com.zillo.mvvmproject.R
import com.zillo.mvvmproject.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    lateinit var context: Context

    lateinit var mainActivityViewModel: MainActivityViewModel

    private var viewManager = LinearLayoutManager(this)
    private lateinit var mainrecycler: ShimmerRecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this@MainActivity
        mainrecycler = findViewById(R.id.recycler)
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        //Displaying data placeholder before getting from server side
        mainrecycler.showShimmerAdapter();

        initialiseAdapter()

    }

    private fun initialiseAdapter(){
        mainrecycler.layoutManager = viewManager
        mainrecycler.layoutManager = GridLayoutManager(applicationContext, 2, LinearLayoutManager.VERTICAL, false)

        observeData()
    }

    fun observeData(){
        mainActivityViewModel.getUser()?.observe(this, Observer{
            Log.i("data",it.toString())
            mainrecycler.adapter= ImageRecyclerAdapter(mainActivityViewModel, it, this)

            //Hiding the placeholder after getting data from server side
            mainrecycler.hideShimmerAdapter();

        })
    }

}
