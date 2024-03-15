package com.example.luciannamendonca_comp304lab2_exercise1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_enter = findViewById<Button>(R.id.btn_enter)
        btn_enter.setOnClickListener(){
            val intent = Intent(this, HomeTypeActivity::class.java)
            startActivity(intent)
        }
    }
}