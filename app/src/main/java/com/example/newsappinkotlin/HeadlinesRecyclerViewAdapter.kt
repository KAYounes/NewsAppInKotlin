package com.example.newsappinkotlin

import android.icu.util.Calendar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.news_card_view.view.*

class HeadlinesRecyclerViewAdapter(var headLines: List<HeadLineModel>?): RecyclerView.Adapter<HeadlinesRecyclerViewAdapter.HeadLineHolder>(){

    class HeadLineHolder(headlineCard: View): RecyclerView.ViewHolder(headlineCard){

        fun onBInd(headline: HeadLineModel){
            itemView.HeadLineTitle.text =headline.headLineTitle
            itemView.HeadLineSource.text = headline.headLineSource + "•" + getHoursAgo(headline.headLinePublish)

            Glide.with(itemView)
                .load(headline.headLineThumbNail)
                .into(itemView.HeadLineThumbNail)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadLineHolder = HeadLineHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.news_card_view, parent, false))

    override fun getItemCount() = headLines!!.size

    override fun onBindViewHolder(holder: HeadLineHolder, position: Int) {
        var headline = headLines!![position]
        holder.onBInd(headline)
    }


}

private fun getHoursAgo(published: String): String{
    var publishedHours = published.split("T","Z")[1].split(":")[0].toInt()
    var publishedDay = published.split("T","Z")[0].split("-")[2].toInt()

    var today = Calendar.getInstance();
    var currentDay = today.time.toString().split(" ")[2].toInt()
    var currentHours = today.time.toString().split(" ")[3].split(":")[0].toInt()

    return (currentHours - (publishedHours - 24*(currentDay - publishedDay) )).toString()
}