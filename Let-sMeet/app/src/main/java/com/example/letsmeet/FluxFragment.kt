package com.example.letsmeet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.letsmeet.databinding.ActivityMainBinding
import com.example.letsmeet.onlineAPI.PlacesStrasbourgAPIRepository
import com.example.letsmeet.onlineAPI.PlacesStrasbourgAPIService
import com.example.letsmeet.onlineAPI.PlacesStrasbourgAPIViewModel
import com.example.letsmeet.onlineAPI.PlacesStrasbourgAPIViewModelFactory

class FluxFragment : Fragment()
{
/*    lateinit var viewModel : PlacesStrasbourgAPIViewModel
    lateinit var binding : ActivityMainBinding
    private val adapter = PlaceAdapter()*/


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val inflation = inflater.inflate(R.layout.fragment_flux, container, false)

        /*binding = ActivityMainBinding.inflate(layoutInflater)
        val strasbourgAPIService = PlacesStrasbourgAPIService.getInstance()
        val strasbourgAPIRepository = PlacesStrasbourgAPIRepository(strasbourgAPIService)
        binding.recyclerview.adapter = adapter

        viewModel = ViewModelProvider(this, PlacesStrasbourgAPIViewModelFactory(strasbourgAPIRepository))
            .get(PlacesStrasbourgAPIViewModel::class.java)

        viewModel.liveData.observe(this, {
            adapter.setPlaces(it)
        })

        viewModel.errorMessage.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        viewModel.loading.observe(this, Observer {
            if(it)
            {
                binding.progressDialog.visibility = View.VISIBLE
            }
            else
            {
                binding.progressDialog.visibility = View.GONE
            }
        })

        viewModel.getAllPlaces()*/

        return inflation
    }
}