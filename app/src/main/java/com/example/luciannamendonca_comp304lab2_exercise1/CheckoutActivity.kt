package com.example.luciannamendonca_comp304lab2_exercise1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class CheckoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        // get intent extra
        val optionChecked = intent.getStringArrayListExtra("optionsChecked")

        // radio group obj
        val radioGroup = findViewById<RadioGroup>(R.id.radio_group)

        // track options added
        val addedOptions = HashSet<String>()

        // display a radio button foreach option checked
        optionChecked?.forEach { apartment ->
            if (!addedOptions.contains(apartment)) { // Check if the option is not already added
                val radioButton = RadioButton(this)
                radioButton.text = apartment
                radioGroup.addView(radioButton)

                addedOptions.add(apartment) // Add the option to the set of added options
            }
        }

        // checkout btn
        val btnCheckout = findViewById<Button>(R.id.btn_checkout)
        btnCheckout.setOnClickListener(){

            val checkedRadioButtonId = radioGroup.checkedRadioButtonId

            if (checkedRadioButtonId != -1) { // if radiobtn is checked

                val checkedRadioButton = findViewById<RadioButton>(checkedRadioButtonId)

                // txt of the checked radiobtn
                val checkedText = checkedRadioButton.text.toString()

                val intent2 = Intent(this, PaymentOptionActivity::class.java)
                intent2.putExtra("optionToCheckout", checkedText)
                startActivity(intent2)

            } else {
                // No radio button is checked
                Toast.makeText(this, "Hey, you need to select your desired Home",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}