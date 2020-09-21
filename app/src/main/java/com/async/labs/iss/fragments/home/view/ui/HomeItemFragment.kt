package com.async.labs.iss.fragments.home.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.async.labs.iss.databinding.FragmentHomeItemBinding
import com.async.labs.iss.fragments.home.service.model.HomeItemAbout
import com.async.labs.iss.fragments.home.view.adapter.AdapterSubtitle
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.view.*

class HomeItemFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentHomeItemBinding? = null
    private val binding get() = _binding!!

    private val args: HomeItemFragmentArgs by navArgs()

    private lateinit var homeItemAbout: HomeItemAbout
    private val adapterSubtitle = AdapterSubtitle()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeItemAbout = args.homeItemAbout
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapterSubtitle.submitList(homeItemAbout.subtitle)

        binding.toolbar.toolbar_text_view_title.text = homeItemAbout.title
        binding.description.text = homeItemAbout.description
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterSubtitle
            setHasFixedSize(true)
        }

        binding.youtubePlayerView.addYouTubePlayerListener(object :
            AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(homeItemAbout.youtubeId!!, 0F)
            }
        })

        setOnClickListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            toolbar.back_button.id -> {
                requireActivity().onBackPressed()
            }
        }
    }

    private fun setOnClickListeners() {
        toolbar.back_button.setOnClickListener(this)
    }
}