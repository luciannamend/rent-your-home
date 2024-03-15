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

class ApartmentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view =  inflater.inflate(
            R.layout.fragment_apartment, container, false)

        // checkbox obj
        val ckApt1 = view.findViewById<CheckBox>(R.id.ck_visit_apt1)
        val ckApt2 = view.findViewById<CheckBox>(R.id.ck_visit_apt2)
        val ckApt3 = view.findViewById<CheckBox>(R.id.ck_visit_apt3)

        // txt addresses and prices
        val addressApt1 = view.findViewById<TextView>(R.id.txt_address_apt1).text.toString()
        val priceApt1 = view.findViewById<TextView>(R.id.txt_price_apt1).text.toString()
        val addressAndPriceApt1 = addressApt1 + priceApt1
        val addressApt2 = view.findViewById<TextView>(R.id.txt_address_apt2).text.toString()
        val priceApt2 = view.findViewById<TextView>(R.id.txt_price_apt2).text.toString()
        val addressAndPriceApt2 = addressApt2 + priceApt2
        val addressApt3 = view.findViewById<TextView>(R.id.txt_address_apt3).text.toString()
        val priceApt3 = view.findViewById<TextView>(R.id.txt_price_apt3).text.toString()
        val addressAndPriceApt3 = addressApt3 + priceApt3

        // list of checked options to visit
        val optionChecked = arrayListOf<String>()

        // btn proceed
        val btnProceed = view.findViewById<Button>(R.id.btn_apt_proceed)
        btnProceed.setOnClickListener(){

            if (ckApt1.isChecked){
                optionChecked.add(addressAndPriceApt1)
            }
            if (ckApt2.isChecked){
                optionChecked.add(addressAndPriceApt2)
            }
            if (ckApt3.isChecked){
                optionChecked.add(addressAndPriceApt3)
            }

            if(optionChecked.isEmpty()){
                Toast.makeText(requireContext(), "Please, select the apartment you want to visit",
                    Toast.LENGTH_LONG).show()
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