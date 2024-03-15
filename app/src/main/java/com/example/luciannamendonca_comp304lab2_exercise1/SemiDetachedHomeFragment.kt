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

class SemiDetachedHomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(
            R.layout.fragment_semi_detached_home, container, false)

        // checkbox obj
        val ckSemiDetached1 = view.findViewById<CheckBox>(R.id.ck_visit_semidetached1)
        val ckSemiDetached2 = view.findViewById<CheckBox>(R.id.ck_visit_semidetached2)
        val ckSemiDetached3 = view.findViewById<CheckBox>(R.id.ck_visit_semidetached3)

        // txt addresses and prices
        val addressSemiDetached1 = view.findViewById<TextView>(
            R.id.txt_address_semidetached1).text.toString()
        val priceSemiDetached1 = view.findViewById<TextView>(
            R.id.txt_price_semidetached1).text.toString()
        val addressAndPriceSemiDetached1 = addressSemiDetached1 + priceSemiDetached1
        val addressSemiDetached2 = view.findViewById<TextView>(
            R.id.txt_address_semidetached2).text.toString()
        val priceSemiDetached2 = view.findViewById<TextView>(
            R.id.txt_price_semidetached2).text.toString()
        val addressAndPriceSemiDetached2 = addressSemiDetached2 + priceSemiDetached2
        val addressSemiDetached3 = view.findViewById<TextView>(
            R.id.txt_address_semidetached3).text.toString()
        val priceSemiDetached3 = view.findViewById<TextView>(
            R.id.txt_price_semidetached3).text.toString()
        val addressAndPriceSemiDetached3 = addressSemiDetached3 + priceSemiDetached3

        // list of checked options to visit
        val optionChecked = arrayListOf<String>()

        // btn proceed
        val btnProceed = view.findViewById<Button>(R.id.btn_semidetached_proceed)
        btnProceed.setOnClickListener(){

            if (ckSemiDetached1.isChecked){
                optionChecked.add(addressAndPriceSemiDetached1)
            }
            if (ckSemiDetached2.isChecked){
                optionChecked.add(addressAndPriceSemiDetached2)
            }
            if (ckSemiDetached3.isChecked){
                optionChecked.add(addressAndPriceSemiDetached3)
            }

            if(optionChecked.isEmpty()){
                Toast.makeText(requireContext(), "Please, select the semi-detached home " +
                        "you want to visit", Toast.LENGTH_LONG).show()
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