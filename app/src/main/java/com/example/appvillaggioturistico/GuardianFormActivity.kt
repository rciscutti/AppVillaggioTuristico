package com.example.appvillaggioturistico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.WindowCompat
import com.example.appvillaggioturistico.databinding.ActivityGuardianFormBinding
import com.example.appvillaggioturistico.databinding.ActivityMainBinding

class GuardianFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGuardianFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityGuardianFormBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val guardiani = arrayOf("Alice", "Bob", "Charlie", "Dave")

        val spinner = binding.chooseGuardianSpinner

        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, guardiani)

        spinner.adapter = arrayAdapter
        spinner.onItemClickListener = object : AdapterView.OnItemSelectedListener,
            AdapterView.OnItemClickListener {

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(applicationContext, "Click", Toast.LENGTH_SHORT).show()
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(applicationContext, "Il guardiano selezionato è ${guardiani[position]}", Toast.LENGTH_SHORT).show()
            }
        }

    }
}