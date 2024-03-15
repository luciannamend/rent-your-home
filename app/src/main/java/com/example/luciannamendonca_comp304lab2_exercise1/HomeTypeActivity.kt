package com.example.luciannamendonca_comp304lab2_exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment

class HomeTypeActivity : AppCompatActivity() {

    //private val homeList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_type)
        addFragment(HomeTypeSelectionFragment())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.home_type_menu, menu)
        return true
    }

    // when a type is selected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // switch the fragment depending on the selected option
        when (item.itemId){

            R.id.apartment_option -> {
                replaceFragment(ApartmentFragment())
                return true
            }

            R.id.detached_home_option -> {
                replaceFragment(DetachedHomeFragment()) //CREATE FRAGMENT
                return true
            }

            R.id.semi_detached_home_option -> {
                replaceFragment(SemiDetachedHomeFragment()) //CREATE FRAGMENT
                return true
            }

            R.id.condominium_option -> {
                replaceFragment(CondominiumFragment()) //CREATE FRAGMENT
                return true
            }

            R.id.town_house_option -> {
                replaceFragment(TownHouseFragment()) //CREATE FRAGMENT
                return true
            }

            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    // method to add fragment
    private fun addFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .add((R.id.home_selection_fragment_container), fragment)
            .commit()
    }

    // method to replace fragment
    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.home_selection_fragment_container, fragment)
            .commit()
    }
}