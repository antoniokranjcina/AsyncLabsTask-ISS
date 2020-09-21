package com.async.labs.iss.fragments.location.view.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.async.labs.iss.databinding.FragmentLocationBinding
import com.async.labs.iss.fragments.location.service.model.CurrentLocation
import com.async.labs.iss.fragments.location.service.repository.RepositoryCurrentLocation
import com.async.labs.iss.fragments.location.viewmodel.ViewModelCurrentLocation
import com.async.labs.iss.fragments.location.viewmodel.ViewModelFactoryCurrentLocation
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class LocationFragment : Fragment(), OnMapReadyCallback {

    private var _binding: FragmentLocationBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ViewModelCurrentLocation
    private lateinit var currentLocation: CurrentLocation

    // UI
    private lateinit var gMap: GoogleMap
    private lateinit var mMapView: MapView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLocationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            ViewModelFactoryCurrentLocation(RepositoryCurrentLocation())
        ).get(ViewModelCurrentLocation::class.java)
        viewModel.getCurrentLocation()
        viewModel.getResponse().observe(viewLifecycleOwner, { response ->
            currentLocation = response.body()!!
            Log.d(
                "LocationFragmentViewModel",
                "onViewCreated: $currentLocation"
            )

            mMapView = binding.mapView
            mMapView.onCreate(null)
            mMapView.onResume()
            mMapView.getMapAsync(this)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onMapReady(googleMap: GoogleMap) {
        gMap = googleMap
        gMap.mapType = GoogleMap.MAP_TYPE_TERRAIN

        val currentISSLocation =
            CameraPosition.builder().target(
                LatLng(
                    currentLocation.issPosition.latitude,
                    currentLocation.issPosition.longitude
                )
            ).zoom(0.0F).bearing(0F).tilt(0F).build()
        gMap.moveCamera(CameraUpdateFactory.newCameraPosition(currentISSLocation))

        gMap.addMarker(
            MarkerOptions().position(
                LatLng(
                    currentLocation.issPosition.latitude,
                    currentLocation.issPosition.longitude
                )
            ).title("ISS - International Space Station")
        )

        binding.radioGroupMap.setOnCheckedChangeListener { _, checkedId ->
            when (resources.getResourceEntryName(checkedId)) {
                "radio_button_terrain" -> gMap.mapType = GoogleMap.MAP_TYPE_TERRAIN
                "radio_button_satellite" -> gMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
                "radio_button_hybrid" -> gMap.mapType = GoogleMap.MAP_TYPE_HYBRID
            }
        }
    }
}