// Logger.getLogger(MainActivity::class.java.name).warning("" + fram.javaClass)

package com.example.letsmeet

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.letsmeet.databinding.ActivityMainBinding
import com.example.letsmeet.onlineAPI.PlacesStrasbourgAPIRepository
import com.example.letsmeet.onlineAPI.PlacesStrasbourgAPIService
import com.example.letsmeet.onlineAPI.PlacesStrasbourgAPIViewModel
import com.example.letsmeet.onlineAPI.PlacesStrasbourgAPIViewModelFactory
import com.google.android.material.navigation.NavigationView
import okhttp3.internal.notifyAll
import java.util.*
import java.util.logging.Logger
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity()
{

//    private lateinit var binding: ActivityMainBinding

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var navView: NavigationView
    private lateinit var fragmentLayout: FrameLayout

    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        setContentView(R.layout.activity_main)

        // TEMP



//        val binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val retrofitService = PlacesStrasbourgAPIService.getInstance()
//        val adapter = PlaceAdapter()
//        var viewModel = ViewModelProvider(this,
//            PlacesStrasbourgAPIViewModelFactory(PlacesStrasbourgAPIRepository(retrofitService)))
//            .get(PlacesStrasbourgAPIViewModel::class.java)
//
//        binding.recyclerViewMain.adapter = adapter
//        viewModel.liveData.observe(this, androidx.lifecycle.Observer {
//            Log.d("Main Activity", "onCreate : $it")
//            adapter.setPlacesList(it)
//        })
//        viewModel.errorMessage.observe(this, androidx.lifecycle.Observer {
//
//        })
//        viewModel.getAllPlaces()
        // FIN TEMP

        fragmentLayout = findViewById(R.id.fragment_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar
        actionBar?.show()

        drawer = findViewById(R.id.drawer_layout)
//
//        toggle = ActionBarDrawerToggle(this, drawer, 0, 0)
//        drawer.addDrawerListener(toggle)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        supportActionBar?.setHomeButtonEnabled(true)
//
//        toggle.syncState()
//
        navView = findViewById(R.id.drawer_nav_view)
        setNavDrawerEvent()

        // Open the Flux as the default page
        var fram = supportFragmentManager.beginTransaction()
        fram.replace(R.id.fragment_main, FluxFragment())
        fram.commit()


    }

    /*fun receivedNewPjoto(place : Place)
    {
        runOnUiThread
        {
            placeList.add(newPlace)
            adapter.notifyAll()
        }

    }*/

    /*override fun onStart() {
        super.onStart()
        if(placeList.size == 0)
        {
            requestPlace()
        }
    }*/

    /**
     * When a slide from left to right happened
     */
//    override fun onSupportNavigateUp(): Boolean {
//        drawer.openDrawer(navView)
//        return true
//    }

    /********************************
     *          DRAWER              *
     ********************************/

    /**
     * When the phone's back button is pressed
     */
    override fun onBackPressed() {
        if(this.drawer.isDrawerOpen(GravityCompat.START))
        {
            this.drawer.closeDrawer(GravityCompat.START)
        }
        else
        {
            super.onBackPressed()
        }
    }

    private fun setNavDrawerEvent()
    {
        navView.setNavigationItemSelectedListener { menuItem ->
            this.onBackPressed()
            val fram = supportFragmentManager.beginTransaction()
            when (menuItem.itemId)
            {
                R.id.drawer_flux ->
                {
                    fram.replace(R.id.fragment_main, FluxFragment())
                    fram.commit()
                    true
                }
                R.id.drawer_my_events ->
                {
                    Toast.makeText(this, R.string.my_events, Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.drawer_contact ->
                {
                    Toast.makeText(this, R.string.contacts, Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.drawer_settings ->
                {
                    Toast.makeText(this, R.string.settings, Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.drawer_disconnection ->
                {
                    Toast.makeText(this, R.string.disconnection, Toast.LENGTH_SHORT).show()
                    true
                }
                else ->
                {
                    false
                }
            }
        }
    }

    /********************************
     *          TOOLBAR             *
     ********************************/

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
//        searchItem = menu?.findItem(R.id.toolbar_search)
//        searchView=searchItem?.actionView
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.toolbar_search ->
            {
                Toast.makeText(this, R.string.toolbar_search, Toast.LENGTH_SHORT).show()
                true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}