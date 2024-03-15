package com.example.luciannamendonca_comp304lab2_exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment

class CustomerInformationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_information)

        val paymentMethod = intent.getStringExtra("paymentMethod")

        if (paymentMethod == "Cash"){
            replaceFragment(CashFragment())
        }
        else{
            replaceFragment(CreditAndDebitCardFragment())
        }

    }

    // method to replace fragment if its cash or card
    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace((R.id.information_fragment_container), fragment)
            .commit()
    }
}