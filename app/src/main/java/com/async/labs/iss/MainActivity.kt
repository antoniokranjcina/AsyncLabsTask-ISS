package com.async.labs.iss

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.async.labs.iss.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.toolbar.view.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = resources.getColor(R.color.theme_color, theme)
        //window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        val navController = findNavController(R.id.fragment)

        binding.bottomNavigation.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.nav_twitter -> {
                    binding.bottomNavigation.visibility = View.VISIBLE
                    setToolbar("Twitter")
                }
                R.id.nav_home -> {
                    binding.bottomNavigation.visibility = View.VISIBLE
                    setToolbar("Home")
                }
                R.id.nav_location -> {
                    binding.bottomNavigation.visibility = View.VISIBLE
                    setToolbar("Location")
                }
            }
        }
    }

    private fun setToolbar(title: String) {
        binding.toolbar.toolbar_text_view_title.text = title
    }
}