package com.async.labs.iss.fragments.twitter

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.async.labs.iss.databinding.FragmentTwitterBinding

class TwitterFragment : Fragment() {

    private var _binding: FragmentTwitterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTwitterBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.webView.webViewClient = WebViewClient()
        val webViewSettings = binding.webView.settings
        webViewSettings.javaScriptEnabled = true
        binding.webView.loadUrl("https://twitter.com/space_station")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}