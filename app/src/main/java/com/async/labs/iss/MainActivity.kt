package com.async.labs.iss

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.async.labs.iss.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.dialog_help.view.*
import kotlinx.android.synthetic.main.fragment_twitter.*
import kotlinx.android.synthetic.main.toolbar_main_frag.view.*
import kotlinx.android.synthetic.main.toolbar_sub_frag.view.toolbar_text_view_title

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
                    setStatusBarAndToolbar(
                        R.color.theme_color, true, "Twitter",
                        toolbar = true,
                        bottomNavigation = true
                    )
                    binding.toolbar.help_button.visibility = View.GONE
                }
                R.id.nav_home -> {
                    setStatusBarAndToolbar(
                        R.color.theme_color, true, "Home",
                        toolbar = true,
                        bottomNavigation = true
                    )
                    binding.toolbar.help_button.visibility = View.VISIBLE
                }
                R.id.nav_location -> {
                    setStatusBarAndToolbar(
                        R.color.white, false, "",
                        toolbar = false,
                        bottomNavigation = true
                    )
                }
                R.id.homeItemFragment -> {
                    setStatusBarAndToolbar(
                        R.color.theme_color, true, "",
                        toolbar = false,
                        bottomNavigation = false
                    )
                }
            }
        }

        binding.toolbar.help_button.setOnClickListener {
            val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_help, null)
            val builder = AlertDialog.Builder(this)
                .setView(dialogView)
                .setTitle("Source")

            builder.show()
            dialogView.text_view_iss_wiki.setOnClickListener {
                val url = "https://en.wikipedia.org/wiki/International_Space_Station"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)
                startActivity(intent)
            }
        }
    }

    private fun setStatusBarAndToolbar(
        color: Int,
        whiteStatusBarLetters: Boolean,
        toolbarTitle: String,
        toolbar: Boolean,
        bottomNavigation: Boolean
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

        if (bottomNavigation) {
            binding.bottomNavigation.visibility = View.VISIBLE
        } else {
            binding.bottomNavigation.visibility = View.GONE
        }
    }

    override fun onBackPressed() {
        try {
            if (web_view.canGoBack()) {
                web_view.goBack()
            } else {
                super.onBackPressed()
            }
        } catch (e: Exception) {
            super.onBackPressed()
        }
    }
}