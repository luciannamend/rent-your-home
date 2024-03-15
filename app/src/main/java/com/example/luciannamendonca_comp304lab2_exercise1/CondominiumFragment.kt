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

class CondominiumFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(
            R.layout.fragment_condominium, container, false)

        // checkbox obj
        val ckCondo1 = view.findViewById<CheckBox>(R.id.ck_visit_condo1)
        val ckCondo2 = view.findViewById<CheckBox>(R.id.ck_visit_condo2)
        val ckCondo3 = view.findViewById<CheckBox>(R.id.ck_visit_condo3)

        // txt addresses and prices
        val addressCondo1 = view.findViewById<TextView>(R.id.txt_address_condo1).text.toString()
        val priceCondo1 = view.findViewById<TextView>(R.id.txt_price_condo1).text.toString()
        val addressAndPriceCondo1 = addressCondo1 + priceCondo1
        val addressCondo2 = view.findViewById<TextView>(R.id.txt_address_condo2).text.toString()
        val priceCondo2 = view.findViewById<TextView>(R.id.txt_price_condo2).text.toString()
        val addressAndPriceCondo2 = addressCondo2 + priceCondo2
        val addressCondo3 = view.findViewById<TextView>(R.id.txt_address_condo3).text.toString()
        val priceCondo3 = view.findViewById<TextView>(R.id.txt_price_condo3).text.toString()
        val addressAndPriceCondo3 = addressCondo3 + priceCondo3

        // list of checked options to visit
        val optionChecked = arrayListOf<String>()

        // btn proceed
        val btnProceed = view.findViewById<Button>(R.id.btn_condo_proceed)
        btnProceed.setOnClickListener(){

            if (ckCondo1.isChecked){
                optionChecked.add(addressAndPriceCondo1)
            }
            if (ckCondo2.isChecked){
                optionChecked.add(addressAndPriceCondo2)
            }
            if (ckCondo3.isChecked){
                optionChecked.add(addressAndPriceCondo3)
            }

            if(optionChecked.isEmpty()){
                Toast.makeText(requireContext(), "Please, select the condominium you want to " +
                        "visit", Toast.LENGTH_LONG).show()
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