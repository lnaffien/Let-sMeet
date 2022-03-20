package com.example.letsmeet.onlineAPI

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letsmeet.Place
import kotlinx.coroutines.*

class PlacesStrasbourgAPIViewModel constructor(private val repository : PlacesStrasbourgAPIRepository): ViewModel()
{
    val errorMessage = MutableLiveData<String>()
    val liveData = MutableLiveData<List<Place>>()
    var job : Job ? = null

    val exceptionHandler = CoroutineExceptionHandler {
            _,
            throwable -> onError("Execption handled : ${throwable.localizedMessage}")
    }

    val loading = MutableLiveData<Boolean>()

    fun getAllPlaces()
    {
        Log.e("API View Model","API request sent")
        job = CoroutineScope(Dispatchers.IO).launch {
            val listPlaces = repository.getAllPlaces()
            Log.e("API View Model","API request end")

            withContext(Dispatchers.Main)
            {
                if(listPlaces.isSuccessful)
                {
                    Log.e("API View Model","API request is successful")
                    liveData.postValue(listPlaces.body())
                    loading.value = false
                }
                else
                {
                     onError("Error : ${listPlaces.message()}")

                }
            }
        }
    }

    fun onError(message : String)
    {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared()
    {
        super.onCleared()
        job?.cancel()
    }
}