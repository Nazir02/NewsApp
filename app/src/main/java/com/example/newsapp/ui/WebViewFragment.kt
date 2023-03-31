package com.example.newsapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import com.example.newsapp.R
import kotlinx.android.synthetic.main.fragment_web_view.*


class WebViewFragment : Fragment() {
    private var mywebview: WebView? = null


    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_web_view, container, false)
        val mBundleUrl: String? = arguments?.getString("img")

        mywebview=view.findViewById(R.id.wv_news)
        if (mBundleUrl != null) {
            mywebview!!.loadUrl(mBundleUrl.toString())
        }
        mywebview!!.settings.javaScriptEnabled = true
        mywebview!!.settings.domStorageEnabled = true
        return view
    }
}