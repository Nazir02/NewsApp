package com.example.newsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import kotlinx.android.synthetic.main.item_loading_state.view.*

class LoaderStateAdapterRv(private val retry: () -> Unit) :
    LoadStateAdapter<LoaderStateAdapterRv.LoaderStateViewHolder>() {

    class LoaderStateViewHolder(item: View, retry: () -> Unit) : RecyclerView.ViewHolder(item) {
        private val tvErrorMessage: TextView = itemView.tvErrorMessage
        private val progressBar: ProgressBar = itemView.progress_bar
        private val btnRetry: Button = itemView.btnRetry

        init {
            btnRetry.setOnClickListener {
                retry.invoke()
            }
        }
        fun bind(loadState: LoadState) {
            if (loadState is LoadState.Error) {
                tvErrorMessage.text = loadState.error.localizedMessage
            }
            progressBar.isVisible = loadState is LoadState.Loading
            tvErrorMessage.isVisible = loadState !is LoadState.Loading
            btnRetry.isVisible = loadState !is LoadState.Loading
        }
    }

    override fun onBindViewHolder(holder: LoaderStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState,
    ): LoaderStateViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_loading_state, parent, false)
        return LoaderStateViewHolder(view, retry)
    }
}