package com.example.letsmeet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.letsmeet.temp.APIStrgAdapter

class FluxFragment : Fragment()
{
/*    lateinit var viewModel : PlacesStrasbourgAPIViewModel
    lateinit var binding : ActivityMainBinding
    private val adapter = PlaceAdapter()*/


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val view : View = inflater.inflate(R.layout.fragment_flux, container, false)

        val p1 = Place("Cathédrale de Strasbourg", "monument", null, null, null, null)
        val p2 = Place("Les Tricheurs", "bar", null, null, null, null)
        val p3 = Place("La Cloche à Fromage", "restauration", null, null, null, null)
        val p4 = Place("Le Kammerzell", "restauration", null, null, null, null)
        val p5 = Place("Musée alsacien", "musée", null, null, null, null)
        val p6 = Place("Petite France", "monument", null, null, null, null)
        val p7 = Place("Musée Tomi Ungerer", "musée", null, null, null, null)
        val p8 = Place("Chez Olland", "restauration", null, null, null, null)
        val p9 = Place("Perl'O", "restauration", null, null, null, null)
        val p10 = Place("Philibar", "bar", null, null, null, null)
        val p11 = Place("Centre commercial les Halles", "monument", null, null, null, null)
        val p12 = Place("Ponts couverts", "monument", null, null, null, null)
        val p13 = Place("Bon j'ai plus d'idées là", "autre", null, null, null, null)
        val p14 = Place("Je sèche complètement", "autre", null, null, null, null)
        val p15 = Place("Vivement l'implémentation de l'API", "autre", null, null, null, null)


        val arrayTemp : ArrayList<Place> = arrayListOf(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15)
        var adapter: APIStrgAdapter = APIStrgAdapter()
        adapter.addPlaceList(arrayTemp)
        var recyclerView : RecyclerView = view.findViewById(R.id.recycler_view_main)
        var linearLayoutManager = LinearLayoutManager(view.context)

        recyclerView.layoutManager = linearLayoutManager

        recyclerView.adapter = adapter

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

        return view
    }
}