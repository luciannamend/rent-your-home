package com.example.luciannamendonca_comp304lab2_exercise1

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CreditAndDebitCardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(
            R.layout.fragment_credit_and_debit_card, container, false)

        val btn_submit = view.findViewById<Button>(R.id.btn_submit_card)
        btn_submit.setOnClickListener(){
            val name = view.findViewById<EditText>(R.id.customer_name).text.toString()
            val cardInfo = view.findViewById<EditText>(R.id.card_info).text.toString()
            val address = view.findViewById<EditText>(R.id.customer_address).text.toString()
            val email = view.findViewById<EditText>(R.id.customer_email).text.toString()

            // validation for required fields
            if (name.isEmpty() || cardInfo.isEmpty() || address.isEmpty() || email.isEmpty()) {
                Toast.makeText(requireContext(), "Full name, Card, Address and Email " +
                        "fields are required", Toast.LENGTH_SHORT).show()
            } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(requireContext(), "Invalid email format", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(requireContext(), SubmissionActivity::class.java)
                startActivity(intent)
            }




        }

        // Inflate the layout for this fragment
        return view
    }
}