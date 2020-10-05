package com.example.newsappinkotlin.ui.destinations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsappinkotlin.R
import com.example.newsappinkotlin.adapters.HeadlinesRecyclerViewAdapter
import com.example.newsappinkotlin.models.HeadLineModel
import com.example.newsappinkotlin.viewmodels.HeadLinesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_headlines.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: HeadLinesViewModel
    lateinit var feedAdapter: HeadlinesRecyclerViewAdapter
    lateinit var linLayMan: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_nav_view.setupWithNavController(findNavController(R.id.nav_host_fragment_container))

        supportActionBar?.title = "Hot Headlines"

        viewModel = ViewModelProvider(this).get(HeadLinesViewModel::class.java)

        viewModel.HeadLinesMutableLiveDate.observe(this, Observer { adapter(viewModel.getNews().value) })
        linLayMan = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        newsFeedRecyclerView.adapter = feedAdapter

    }

    fun adapter(headlines: List<HeadLineModel>?){
        feedAdapter = HeadlinesRecyclerViewAdapter(headlines)
    }


}


