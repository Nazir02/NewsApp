package com.example.newsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.model.Article
import kotlinx.android.synthetic.main.item_recycler.view.*
import javax.inject.Inject

class PagingAdapter @Inject constructor() :
    PagingDataAdapter<Article, PagingAdapter.viewHolder>(Diff()) {
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        getItem(position)?.let { holder.bindPost(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return viewHolder(view)
    }

    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iv_item = itemView.iv_news
        val tv_title = itemView.tv_title_lable
        val tv_descriptions = itemView.tv_descriptions


        fun bindPost(model: Article) {
            Glide.with(itemView.context).load(model.urlToImage).into(iv_item)
            tv_title.text = model.title
            tv_descriptions.text = model.description
        }
    }
}

class Diff : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean =
        oldItem.title == newItem.title


    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean =
        oldItem.description == newItem.description

}
