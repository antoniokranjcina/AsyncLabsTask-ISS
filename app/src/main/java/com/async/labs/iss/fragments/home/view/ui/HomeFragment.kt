package com.async.labs.iss.fragments.home.view.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.async.labs.iss.databinding.FragmentHomeBinding
import com.async.labs.iss.fragments.home.service.model.HomeItemAbout
import com.async.labs.iss.fragments.home.service.repository.HomeItemAboutRepository
import com.async.labs.iss.fragments.home.view.adapter.AdapterHome
import com.async.labs.iss.fragments.home.viewmodel.HomeItemAboutViewModel
import com.async.labs.iss.fragments.home.viewmodel.HomeItemAboutViewModelFactory

class HomeFragment : Fragment(), AdapterHome.OnItemClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val adapterHome = AdapterHome(this)
    private lateinit var viewModel: HomeItemAboutViewModel
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterHome
            setHasFixedSize(true)
        }

        requestResponse()
        viewModel.getResponse().observe(viewLifecycleOwner, { response ->
            adapterHome.submitList(response.body())
            Log.d("HomeFragment", "onViewCreated: " + response.body())
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(homeItemAbout: HomeItemAbout) {
        val action = HomeFragmentDirections.actionNavHomeToHomeItemFragment(homeItemAbout)
        try {
            navController.navigate(action)
        } catch (e: Exception) {
            Log.d("HomeFragment", "exception: " + e.message)
        }
    }

    private fun requestResponse() {
        viewModel =
            ViewModelProvider(this, HomeItemAboutViewModelFactory(HomeItemAboutRepository()))
                .get(HomeItemAboutViewModel::class.java)
        viewModel.getHomeItemAbout()
    }
}