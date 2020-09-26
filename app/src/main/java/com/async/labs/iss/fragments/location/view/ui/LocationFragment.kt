package com.async.labs.iss.fragments.location.view.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.async.labs.iss.databinding.FragmentLocationBinding
import com.async.labs.iss.fragments.location.view.adapter.ViewPagerAdapter
import com.async.labs.iss.fragments.location.viewpageradapterfragments.googlemaps.view.ui.GoogleMapsLocationFragment
import com.async.labs.iss.fragments.location.viewpageradapterfragments.youtubelivestream.YoutubeLiveStreamFragment
import com.google.android.material.tabs.TabLayoutMediator

class LocationFragment : Fragment() {
    private var _binding: FragmentLocationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLocationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentList = arrayListOf(
            GoogleMapsLocationFragment(),
            YoutubeLiveStreamFragment()
        )
        val fragmentsNames = arrayListOf("Google Maps", "Live Stream")

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.viewPagerLocation.adapter = adapter
        binding.tabLayoutLocation.setTabTextColors(
            Color.parseColor("#ffffffff"),
            Color.parseColor("#03DAC5")
        )

        TabLayoutMediator(binding.tabLayoutLocation, binding.viewPagerLocation) { tab, position ->
            tab.text = fragmentsNames[position]
        }.attach()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}