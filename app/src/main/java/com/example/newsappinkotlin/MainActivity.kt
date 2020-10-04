package com.example.newsappinkotlin

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_headlines.*

class MainActivity : AppCompatActivity() {
    lateinit var feedAdapter: HeadlinesRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_nav_view.setupWithNavController(findNavController(R.id.nav_host_fragment_container))

        supportActionBar?.title = "Recent Hot Headlines for You"
        newsFeedRecyclerView.adapter = feedAdapter
        newsFeedRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        requestApiHit()
    }
    fun requestApiHit(){
        ApiClient.requestTopHeadLines(::setAdapter, ::onError)
    }

    fun onError() {
        TODO("Not yet implemented")
    }

    fun setAdapter(topHeadLinesResponse: TopHeadLinesResponse?) {
        feedAdapter.headLines = bind(topHeadLinesResponse)
    }

    fun bind(topHeadLinesResponse: TopHeadLinesResponse?): HeadLineModel{
        lateinit var headline: HeadLineModel
        if (topHeadLinesResponse != null) {
            headline.headLinePublish = topHeadLinesResponse.published
            headline.headLineSource = topHeadLinesResponse.headLineSource.toString()
            headline.headLineThumbNail = topHeadLinesResponse.headLineThumbNail
            headline.headLineTitle = topHeadLinesResponse.headLineTitle
            return headline
        }
    }
}


