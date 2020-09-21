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

        val navController = findNavController(R.id.fragment)

        binding.bottomNavigation.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.nav_twitter -> {
                    setStatusBarAndToolbar(R.color.theme_color, true, "Twitter", true)
                    binding.bottomNavigation.visibility = View.VISIBLE
                }
                R.id.nav_home -> {
                    setStatusBarAndToolbar(R.color.theme_color, true, "Home", true)
                    binding.bottomNavigation.visibility = View.VISIBLE
                }
                R.id.nav_location -> {
                    setStatusBarAndToolbar(R.color.white, false, "", false)
                    binding.bottomNavigation.visibility = View.VISIBLE
                }
                R.id.homeItemFragment -> {
                    setStatusBarAndToolbar(R.color.theme_color, true, "", false)
                    binding.bottomNavigation.visibility = View.GONE
                }
            }
        }
    }

    private fun setStatusBarAndToolbar(
        color: Int,
        whiteStatusBarLetters: Boolean,
        toolbarTitle: String,
        toolbar: Boolean
    ) {
        binding.toolbar.toolbar_text_view_title.text = toolbarTitle

        window.statusBarColor = resources.getColor(color, theme)
        if (!whiteStatusBarLetters) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_IMMERSIVE
        }

        if (toolbar) {
            binding.toolbar.visibility = View.VISIBLE
        } else {
            binding.toolbar.visibility = View.GONE

        }
    }
}