package com.example.luciannamendonca_comp304lab2_exercise1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class PaymentOptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_option)

        // intent extra obj
        val optionToCheckout = intent.getStringExtra("optionToCheckout")

        // set checked option to display on textview
        val display = findViewById<TextView>(R.id.display_selected_home)
        display.text = optionToCheckout

        val radioGroup = findViewById<RadioGroup>(R.id.radio_group_payment)

        val btnConfirmPayment = findViewById<Button>(R.id.btn_confirm_payment)
        btnConfirmPayment.setOnClickListener(){
            val selectedRadioButtonId  = radioGroup.checkedRadioButtonId

            // if any radiobtn is checked
            if (selectedRadioButtonId  != -1) {
                // selected radiobtn
                val selectedPayment = findViewById<RadioButton>(selectedRadioButtonId )

                //  selected radiobtn txt
                val selectedPaymentMethod = selectedPayment.text.toString()

                val intent3 = Intent(this, CustomerInformationActivity::class.java)
                intent3.putExtra("paymentMethod", selectedPaymentMethod)
                startActivity(intent3)

            } else {
                // No radio button is checked
                Toast.makeText(this, "Sorry, you need to select your payment method",
                    Toast.LENGTH_LONG).show()
            }
        }


    }
}