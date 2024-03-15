package com.example.luciannamendonca_comp304lab2_exercise1

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast

class TownHouseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view =  inflater.inflate(
            R.layout.fragment_town_house, container, false)

        // checkbox obj
        val ckTH1 = view.findViewById<CheckBox>(R.id.ck_visit_townhouse1)
        val ckTH2 = view.findViewById<CheckBox>(R.id.ck_visit_townhouse2)
        val ckTH3 = view.findViewById<CheckBox>(R.id.ck_visit_townhouse3)

        // txt addresses and prices
        val addressTH1 = view.findViewById<TextView>(R.id.txt_address_townhouse1).text.toString()
        val priceTH1 = view.findViewById<TextView>(R.id.txt_price_townhouse1).text.toString()
        val addressAndPriceTH1 = addressTH1 + priceTH1
        val addressTH2 = view.findViewById<TextView>(R.id.txt_address_townhouse2).text.toString()
        val priceTH2 = view.findViewById<TextView>(R.id.txt_price_townhouse2).text.toString()
        val addressAndPriceTH2 = addressTH2 + priceTH2
        val addressTH3 = view.findViewById<TextView>(R.id.txt_address_townhouse3).text.toString()
        val priceTH3 = view.findViewById<TextView>(R.id.txt_price_townhouse3).text.toString()
        val addressAndPriceTH3 = addressTH3 + priceTH3

        // list of checked options to visit
        val optionChecked = arrayListOf<String>()

        // btn proceed
        val btnProceed = view.findViewById<Button>(R.id.btn_townhouse_proceed)
        btnProceed.setOnClickListener(){

            if (ckTH1.isChecked){
                optionChecked.add(addressAndPriceTH1)
            }
            if (ckTH2.isChecked){
                optionChecked.add(addressAndPriceTH2)
            }
            if (ckTH3.isChecked){
                optionChecked.add(addressAndPriceTH3)
            }

            if(optionChecked.isEmpty()){
                Toast.makeText(requireContext(), "Please, select the town house you want to" +
                        " visit", Toast.LENGTH_LONG).show()
            }else{
                // create he intent and send checked apt as extras
                val intent = Intent(requireContext(), CheckoutActivity::class.java)
                intent.putStringArrayListExtra("optionsChecked", optionChecked)
                startActivity(intent)
            }
        }
        return view
    }

}