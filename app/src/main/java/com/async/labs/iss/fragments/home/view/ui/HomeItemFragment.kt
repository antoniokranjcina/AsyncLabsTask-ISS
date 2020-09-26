package com.async.labs.iss.fragments.home.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.async.labs.iss.databinding.FragmentHomeItemBinding
import com.async.labs.iss.fragments.home.service.model.HomeWikipediaItems
import com.async.labs.iss.fragments.home.view.adapter.AdapterSubtitle
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import kotlinx.android.synthetic.main.toolbar_sub_frag.view.*

class HomeItemFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentHomeItemBinding? = null
    private val binding get() = _binding!!

    private val args: HomeItemFragmentArgs by navArgs()

    private lateinit var homeWikipediaItems: HomeWikipediaItems
    private lateinit var navController: NavController
    private val adapterSubtitle = AdapterSubtitle()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeWikipediaItems = args.homeWikipediaItems
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
        navController = Navigation.findNavController(view)

        adapterSubtitle.submitList(homeWikipediaItems.subtitle)

        binding.toolbar.toolbar_text_view_title.text = homeWikipediaItems.title
        binding.description.text = homeWikipediaItems.description
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterSubtitle
            setHasFixedSize(true)
        }

        viewLifecycleOwner.lifecycle.addObserver(binding.youtubePlayerView)

        binding.youtubePlayerView.addYouTubePlayerListener(object :
            AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.cueVideo(homeWikipediaItems.youtubeId!!, 0F)
            }
        })

        setOnClickListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.youtubePlayerView.release()
        _binding = null
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            binding.toolbar.back_button.id -> {
                requireActivity().onBackPressed()
            }
        }
    }

    private fun setOnClickListeners() {
        binding.toolbar.back_button.setOnClickListener(this)
    }

}