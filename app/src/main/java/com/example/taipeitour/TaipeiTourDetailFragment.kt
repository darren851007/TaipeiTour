package com.example.taipeitour

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.taipeitour.databinding.TaipeiTourListDetailFragmentBinding
import com.example.taipeitour.model.DataItem
import com.example.taipeitour.utils.ActivityUtils
import kotlinx.coroutines.NonDisposableHandle.parent

class TaipeiTourDetailFragment : Fragment(), TaipeiTourDetailContract.View {
    private lateinit var binding: TaipeiTourListDetailFragmentBinding
    private val presenter: TaipeiTourDetailContract.Presenter by lazy {
        TaipeiTourDetailPresenter(this)
    }

    companion object {
        fun newInstance(item: DataItem): TaipeiTourDetailFragment {
            val fragmentDetailFragment = TaipeiTourDetailFragment()
            val bundle = Bundle()
            bundle.putSerializable("data", item)
            fragmentDetailFragment.arguments = bundle
            return fragmentDetailFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TaipeiTourListDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        binding.apply {
            toolBar.toolBar.setNavigationOnClickListener {
                (activity as? MainActivity)?.onBackPressed()
            }
        }
    }

    private fun initView() {
        val data = arguments?.getSerializable("data")
        data?.let {
            val data = it as? DataItem
            val url = data?.url
            binding.apply {
                toolBar.toolBar.title = data?.name

//                item?.images.takeIf { !it.isNullOrEmpty() }?.also { images ->
////                    Glide.with(this@TaipeiTourDetailFragment)
////                        .load(images[0].src)
////                        .into(ivDeetail)
////                }

                if (!data?.images.isNullOrEmpty()) {
                    if (data != null) {
                        Glide.with(this@TaipeiTourDetailFragment)
                            .load(data.images?.get(0)?.src)
                            .into(ivDeetail)
                    }
                }
                tvDetailTitle.text = data?.name
                tvDetailDesc.text = data?.introduction?.replace("&nbsp;", " ")
                tvUrl.text = url
                tvUrl.setOnClickListener {
                    if (url != null) {
                        startWebView(url)
                    }
                }
            }
        }

    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun startWebView(url: String) {
        val setting: WebSettings
        binding.apply {
            scrollView.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
            webView.visibility = View.VISIBLE
            setting = webView.settings
            setting.javaScriptEnabled = true
            webView.scrollBarStyle = View.SCROLLBARS_OUTSIDE_OVERLAY
            webView.settings.builtInZoomControls = true
            webView.settings.useWideViewPort = true
            webView.settings.loadWithOverviewMode = true

            webView.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                    view: WebView?,
                    request: WebResourceRequest?
                ): Boolean {
                    view?.loadUrl(url)
                    return true
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    progressBar.visibility = View.GONE
                    super.onPageFinished(view, url)
                }
            }
            webView.loadUrl(url)


        }

    }


}