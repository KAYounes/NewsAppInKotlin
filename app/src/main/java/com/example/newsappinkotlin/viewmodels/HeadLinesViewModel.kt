package com.example.newsappinkotlin.viewmodels

import com.example.newsappinkotlin.network.ApiClient
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsappinkotlin.models.HeadLineModel

class HeadLinesViewModel: ViewModel() {
    var HeadLinesMutableLiveDate: MutableLiveData<HeadLinesViewModel> = MutableLiveData<HeadLinesViewModel>()

    private fun requestData(): HeadLinesViewModel {
        ApiClient.requestTopHeadLines(::updateliveData, ::onError)

    }

    private fun onError() {
        TODO("Not yet implemented")
    }

    private fun updateliveData(list: List<HeadLineModel>) {
        HeadLinesMutableLiveDate
    }

}