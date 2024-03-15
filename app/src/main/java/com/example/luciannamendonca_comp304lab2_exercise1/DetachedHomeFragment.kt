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

class DetachedHomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(
            R.layout.fragment_detached_home, container, false)

        // checkbox obj
        val ckDetached1 = view.findViewById<CheckBox>(R.id.ck_visit_detached1)
        val ckDetached2 = view.findViewById<CheckBox>(R.id.ck_visit_detached2)
        val ckDetached3 = view.findViewById<CheckBox>(R.id.ck_visit_detached3)

        // txt addresses and prices
        val addressDetached1 = view.findViewById<TextView>(
            R.id.txt_address_detached1).text.toString()
        val priceDetached1 = view.findViewById<TextView>(
            R.id.txt_price_detached1).text.toString()
        val addressAndPriceDetached1 = addressDetached1 + priceDetached1
        val addressDetached2 = view.findViewById<TextView>(
            R.id.txt_address_detached2).text.toString()
        val priceDetached2 = view.findViewById<TextView>(
            R.id.txt_price_detached2).text.toString()
        val addressAndPriceDetached2 = addressDetached2 + priceDetached2
        val addressDetached3 = view.findViewById<TextView>(
            R.id.txt_address_detached3).text.toString()
        val priceDetached3 = view.findViewById<TextView>(
            R.id.txt_price_detached3).text.toString()
        val addressAndPriceDetached3 = addressDetached3 + priceDetached3

        // list of checked options to visit
        val optionChecked = arrayListOf<String>()

        // btn proceed
        val btnProceed = view.findViewById<Button>(R.id.btn_detached_proceed)
        btnProceed.setOnClickListener(){

            if (ckDetached1.isChecked){
                optionChecked.add(addressAndPriceDetached1)
            }
            if (ckDetached2.isChecked){
                optionChecked.add(addressAndPriceDetached2)
            }
            if (ckDetached3.isChecked){
                optionChecked.add(addressAndPriceDetached3)
            }

            if(optionChecked.isEmpty()){
                Toast.makeText(requireContext(), "Please, select the detached home " +
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