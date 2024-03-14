package com.example.parcial1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val btn_jugar = findViewById<Button>(R.id.buttonJugar)
        val btn_cultorizate = findViewById<Button>(R.id.buttonCultorizate)

        btn_jugar.setOnClickListener {
            val intent = Intent(this, JugarActivity::class.java)
            startActivity(intent)
        }

        btn_cultorizate.setOnClickListener {

            val intent = Intent(this, CultorizateActivity::class.java)
            startActivity(intent)
        }
    }
}