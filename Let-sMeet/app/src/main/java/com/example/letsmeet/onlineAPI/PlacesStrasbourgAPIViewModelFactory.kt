package com.example.letsmeet.onlineAPI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class PlacesStrasbourgAPIViewModelFactory constructor(private val repository : PlacesStrasbourgAPIRepository) : ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
    {
        return  if(modelClass.isAssignableFrom(PlacesStrasbourgAPIViewModel::class.java))
        {
            PlacesStrasbourgAPIViewModel(this.repository) as T
        }
        else
        {
            throw IllegalArgumentException("ViewModel not found")
        }
    }
}