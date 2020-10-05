package com.example.newsappinkotlin.viewmodels

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import com.example.newsappinkotlin.network.ApiClient
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsappinkotlin.models.HeadLineModel
import com.example.newsappinkotlin.network.ApiEndPoints

class HeadLinesViewModel: ViewModel(), ApiEndPoints {
    var HeadLinesMutableLiveDate: MutableLiveData<List<HeadLineModel>> = MutableLiveData<List<HeadLineModel>>()


    ApiClient.requestTopHeadLines(::returnHeadLines, ::onError)



//    private fun onError() {
////        Toast.makeText( , "Error when calling the api :(", Toast.LENGTH_LONG).show()
//        println("Error → onError was invoked from HeadLinesViewModel")
//    }
//
//    private fun returnHeadLines(list: List<HeadLineModel>){
//        HeadLinesMutableLiveDate.value = list
//    }

    fun getNews(): LiveData<List<HeadLineModel>>{
        requestData()
        return HeadLinesMutableLiveDate
    }

}