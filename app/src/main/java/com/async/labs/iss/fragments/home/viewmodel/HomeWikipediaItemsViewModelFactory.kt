package com.async.labs.iss.fragments.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.async.labs.iss.fragments.home.service.repository.HomeWikipediaItemsRepository

class HomeWikipediaItemsViewModelFactory(private val repository: HomeWikipediaItemsRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeWikipediaItemsViewModel(repository) as T
    }
}