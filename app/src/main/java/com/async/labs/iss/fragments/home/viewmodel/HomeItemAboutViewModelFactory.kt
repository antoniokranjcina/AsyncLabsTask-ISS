package com.async.labs.iss.fragments.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.async.labs.iss.fragments.home.service.repository.HomeItemAboutRepository

class HomeItemAboutViewModelFactory(private val repository: HomeItemAboutRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeItemAboutViewModel(repository) as T
    }
}